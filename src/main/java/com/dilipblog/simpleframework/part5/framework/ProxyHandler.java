package com.dilipblog.simpleframework.part5.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.dilipblog.simpleframework.part5.framework.annotation.Transactional;

public class ProxyHandler implements InvocationHandler {

  private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);
  private final Object objectToHandle;

  public ProxyHandler(final Object objectToHandle) {
    this.objectToHandle = objectToHandle;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (isTransactional(method)) {
      return handleTransaction(method, args);
    }
    return method.invoke(objectToHandle, args);
  }

  private Object handleTransaction(Method method, Object[] args)
      throws InvocationTargetException, IllegalAccessException {
    try {
      beginTransaction();
      final Object result = method.invoke(objectToHandle, args);
      commitTransaction();
      return result;
    } catch (Exception e) {
      rollbackTransaction();
      throw e;
    }
  }

  /**
   * Check whether the method is annotated with @Transactional annotation
   */
  private boolean isTransactional(final Method method) {
    try {
      return objectToHandle.getClass()
          .getMethod(method.getName(), method.getParameterTypes())
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
