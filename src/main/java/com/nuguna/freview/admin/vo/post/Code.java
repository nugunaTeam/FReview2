package com.nuguna.freview.admin.vo.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Code {
  MOJIP("모집"),
  NOTICE("공지"),
  FREE("자유");

  private final String code;

  public static Code from(String code) {
    for (Code c : Code.values()) {
      if (c.getCode().equalsIgnoreCase(code)) {
        return c;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 code 입력 : " + code);
  }
}