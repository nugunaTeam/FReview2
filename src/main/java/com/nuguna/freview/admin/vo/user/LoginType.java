package com.nuguna.freview.admin.vo.user;

import com.nuguna.freview.admin.vo.user.foodType.FoodType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum LoginType {

  GOOGLE("구글"),
  FORM("폼");

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
