package com.nuguna.freview.common.vo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum UserCode {

  ADMIN("ADMIN"),
  STORE("STORE"),
  CUSTOMER("CUSTOMER");

  private final String code;

  public static UserCode from(String code) {
    for (UserCode g : UserCode.values()) {
      if (g.getCode().equalsIgnoreCase(code)) {
        return g;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 UserCode 입력 : " + code);
  }

  public boolean isAdmin() {
    return this == ADMIN;
  }

  public boolean isBoss() {
    return this == STORE;
  }

  public boolean isCustomer() {
    return this == CUSTOMER;
  }
}