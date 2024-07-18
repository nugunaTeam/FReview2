package com.nuguna.freview.customer.validation;

import com.nuguna.freview.customer.validation.annotation.ValidFoodTypes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FoodTypeValidator implements ConstraintValidator<ValidFoodTypes, List<String>> {

  private final Set<String> validFoodTypes = new HashSet<>(Arrays.asList(
      "국밥", "돈까스", "족발", "막창", "피자", "파스타", "햄버거", "스테이크", "마라탕", "짜장면", "짬뽕",
      "탕수육", "텐동", "초밥", "규동", "라멘", "빵", "케이크", "쿠키", "샌드위치", "커피", "커리", "쌀국수", "기타"
  ));

  @Override
  public void initialize(ValidFoodTypes constraintAnnotation) {
  }

  @Override
  public boolean isValid(List<String> value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    for (String foodType : value) {
      if (!validFoodTypes.contains(foodType)) {
        return false;
      }
    }
    return true;
  }
}