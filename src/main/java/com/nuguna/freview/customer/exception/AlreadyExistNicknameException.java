package com.nuguna.freview.customer.exception;

public class AlreadyExistNicknameException extends RuntimeException {

  public AlreadyExistNicknameException() {
    super();
  }

  public AlreadyExistNicknameException(String message) {
    super(message);
  }
}
