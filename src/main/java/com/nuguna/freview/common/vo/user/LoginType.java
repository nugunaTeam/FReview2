package com.nuguna.freview.common.vo.user;

import com.nuguna.freview.common.vo.user.foodType.FoodType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum LoginType {
  GOOGLE("GOOGLE"),
  FORM("FORM");

  private final String code;

  public static FoodType fromCode(String code) {
    for (FoodType c : FoodType.values()) {
      if (c.getCode().equalsIgnoreCase(code)) {
        return c;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 LoginType Code 입력 : " + code);
  }
}