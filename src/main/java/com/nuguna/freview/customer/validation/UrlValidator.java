package com.nuguna.freview.customer.validation;

import com.nuguna.freview.customer.validation.annotation.ValidUrl;
import java.net.MalformedURLException;
import java.net.URL;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<ValidUrl, String> {

  @Override
  public boolean isValid(String urlField, ConstraintValidatorContext context) {
    if (urlField == null || urlField.isEmpty()) {
      return false;
    }

    try {
      new URL(urlField);
      return true;
    } catch (MalformedURLException e) {
      return false;
    }
  }
}