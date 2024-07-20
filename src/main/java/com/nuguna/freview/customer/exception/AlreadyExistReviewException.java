package com.nuguna.freview.customer.exception;

public class AlreadyExistReviewException extends RuntimeException {

  public AlreadyExistReviewException() {
    super();
  }

  public AlreadyExistReviewException(String message) {
    super(message);
  }
}
