package com.nuguna.freview.customer.exception.handler;

import com.nuguna.freview.customer.exception.AlreadyExistNicknameException;
import com.nuguna.freview.customer.exception.IllegalReviewException;
import com.nuguna.freview.customer.exception.IllegalUserSeqException;
import com.nuguna.freview.global.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class CustomerApiExceptionHandler {

  @ExceptionHandler(AlreadyExistNicknameException.class)
  public ResponseEntity<ErrorResponse> handleNicknameException(AlreadyExistNicknameException ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), null), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalReviewException.class)
  public ResponseEntity<ErrorResponse> handleReviewException(IllegalReviewException ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), null), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalUserSeqException.class)
  public ResponseEntity<ErrorResponse> handleIllegalUserSeqException(IllegalUserSeqException ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), null), HttpStatus.BAD_REQUEST);
  }


}
