package com.nuguna.freview.common.vo.experience;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ExperienceCode {
  PROPOSE("PROPOSE"),
  APPLY("APPLY");

  private final String code;

  public static ExperienceCode from(String code) {
    for (ExperienceCode g : ExperienceCode.values()) {
      if (g.getCode().equalsIgnoreCase(code)) {
        return g;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 ExperienceCode 입력 : " + code);
  }
}