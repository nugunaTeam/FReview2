package com.nuguna.freview.common.vo.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum PostCode {
  MOJIP("모집"),
  NOTICE("공지"),
  FREE("자유");

  private final String code;

  public static PostCode from(String code) {
    for (PostCode g : PostCode.values()) {
      if (g.getCode().equalsIgnoreCase(code)) {
        return g;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 PostCode 입력 : " + code);
  }
}