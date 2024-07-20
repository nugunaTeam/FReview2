package com.nuguna.freview.customer.exception;

public class MalformedReviewUrlException extends RuntimeException {

  public MalformedReviewUrlException() {
    super();
  }

  public MalformedReviewUrlException(String message) {
    super(message);
  }
}
