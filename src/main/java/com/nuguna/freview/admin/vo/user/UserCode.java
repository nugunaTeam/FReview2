package com.nuguna.freview.admin.vo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum UserCode {
  ADMIN("관리자"),
  STORE("스토어"),
  CUSTOMER("체험단");

  private final String code;

  public static UserCode from(String code) {
    for (UserCode g : UserCode.values()) {
      if (g.getCode().equalsIgnoreCase(code)) {
        return g;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 MemberGubun 입력 : " + code);
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
