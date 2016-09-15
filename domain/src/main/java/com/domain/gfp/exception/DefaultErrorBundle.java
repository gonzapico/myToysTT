package com.domain.gfp.exception;

/**
 * Created by gfernandez on 8/08/16.
 *
 *  Wrapper around Exceptions used to manage default errors.
 */
public class DefaultErrorBundle implements ErrorBundle {

  private static final String DEFAULT_ERROR_MSG = "Unknown error";

  private final Exception exception;

  public DefaultErrorBundle(Exception exception) {
    this.exception = exception;
  }

  @Override
  public Exception getException() {
    return exception;
  }

  @Override
  public String getErrorMessage() {
    return (exception != null) ? this.exception.getMessage() : DEFAULT_ERROR_MSG;
  }
}
