package com.dilipblog.simpleframework.part6.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dilipblog.simpleframework.part6.framework.annotation.Transactional;

public class ProxyHandler implements InvocationHandler {

  private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);
  private final Object objectToHandle;

  public ProxyHandler(final Object objectToHandle) {
    this.objectToHandle = objectToHandle;
  }

  @Override
  public Object invoke(final Object proxy, final  Method method, final Object[] args) throws Throwable {
    if (isTransactional(method)) {
      logger.info(String.format("Method: %1$s is Transactional. Handling the transaction...",
          method.getName()));
      handleTransaction(method, args);
      logger.info(String.format("Method: %1$s handled through a transaction successfully!",
          method.getName()));
    }
    return method.invoke(objectToHandle, args);
  }

  private Object handleTransaction(final Method method, final Object[] args) throws InvocationTargetException,
      IllegalAccessException {
    try {
      beginTransaction();
      final Object invoke = method.invoke(objectToHandle, args);
      commitTransaction();
      return invoke;
    } catch (Exception e) {
      rollbackTransaction();
      throw e;
    }
  }

  private boolean isTransactional(final Method method) {
    try {
      return objectToHandle.getClass().getMethod(method.getName(), method.getParameterTypes())
          .isAnnotationPresent(Transactional.class);
    } catch (NoSuchMethodException e) {
      return false;
    }
  }

  private void beginTransaction() {
    logger.debug("===============BEGIN TRANSACTION===============");
  }

  private void commitTransaction() {
    logger.debug("===============COMMIT TRANSACTION===============");
  }

  private void rollbackTransaction() {
    logger.error("===============ROLLBACK TRANSACTION===============");
  }

}