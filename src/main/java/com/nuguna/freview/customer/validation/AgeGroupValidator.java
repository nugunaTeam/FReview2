package com.nuguna.freview.customer.validation;

import com.nuguna.freview.customer.validation.annotation.ValidAgeGroup;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeGroupValidator implements ConstraintValidator<ValidAgeGroup, String> {

  private final List<String> validAgeGroups = Arrays.asList("10대", "20대", "30대", "40대", "50대",
      "60대", "70대", "80대", "90대");

  @Override
  public void initialize(ValidAgeGroup constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return validAgeGroups.contains(value);
  }
}