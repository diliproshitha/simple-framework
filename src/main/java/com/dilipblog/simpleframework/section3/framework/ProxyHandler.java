package com.dilipblog.simpleframework.section3.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyHandler implements InvocationHandler {

  private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);
  private final Object objectToHandle;

  public ProxyHandler(final Object objectToHandle) {
    this.objectToHandle = objectToHandle;
  }

  @Override
  public Object invoke(final Object proxy, final  Method method, final Object[] args) throws Throwable {
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