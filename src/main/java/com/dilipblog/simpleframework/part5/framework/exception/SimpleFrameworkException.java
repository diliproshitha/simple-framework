package com.dilipblog.simpleframework.part5.framework.exception;

public class SimpleFrameworkException extends RuntimeException {

  public SimpleFrameworkException(final String message) {
    super(message);
  }

  public SimpleFrameworkException(final Throwable throwable) {
    super("Unknown exception", throwable);
  }

}
