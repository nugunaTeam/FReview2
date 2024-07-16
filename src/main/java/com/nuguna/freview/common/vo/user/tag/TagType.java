package com.nuguna.freview.admin.vo.user.tag;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum TagType {
  STORE("스토어"),
  CUSTOMER("체험단");

  private final String code;

  public static TagType from(String code) {
    for (TagType t : TagType.values()) {
      if (t.getCode().equalsIgnoreCase(code)) {
        return t;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 TagCode 입력 : " + code);
  }

  public boolean isStoreTag() {
    return this == STORE;
  }

  public boolean isCustomerTag() {
    return this == CUSTOMER;
  }

}