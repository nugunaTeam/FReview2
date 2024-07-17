package com.nuguna.freview.customer.exception.handler;

import com.nuguna.freview.customer.exception.AlreadyExistNicknameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class CustomerApiExceptionHandler {

  @ExceptionHandler(AlreadyExistNicknameException.class)
  public ResponseEntity<String> handleNicknameException(AlreadyExistNicknameException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

}
