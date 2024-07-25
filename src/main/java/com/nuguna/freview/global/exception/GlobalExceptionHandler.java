package com.nuguna.freview.global.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
    for (ObjectError error : globalErrors) {
      errors.put("GlobalError : ", error.getDefaultMessage());
    }
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    for (FieldError fieldError : fieldErrors) {
      errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    ErrorResponse errorResponse = new ErrorResponse("유효성 검사 실패", errors);
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), null), HttpStatus.BAD_REQUEST);
  }

}
