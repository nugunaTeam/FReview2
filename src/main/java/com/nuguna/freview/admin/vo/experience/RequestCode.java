package com.nuguna.freview.admin.vo.experience;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum RequestCode {
  PROPOSE("제안"),
  APPLY("지원");

  private final String code;

  public static RequestCode from(String code) {
    for (RequestCode g : RequestCode.values()) {
      if (g.getCode().equalsIgnoreCase(code)) {
        return g;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 RequestCode 입력 : " + code);
  }
}