package com.nuguna.freview.common.vo.user.foodType;

import com.nuguna.freview.common.exception.IllegalFoodTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum FoodType {

  KOREAN("한식"),
  CHINESE("중식"),
  WESTERN("양식"),
  JAPANESE("일식"),
  BAKERY("베이커리");

  private final String code;

  public static FoodType fromCode(String code) {
    for (FoodType c : FoodType.values()) {
      if (c.getCode().equalsIgnoreCase(code)) {
        return c;
      }
    }
    throw new IllegalFoodTypeException("유효하지 않은 FoodType Code 입력 : " + code);
  }
}