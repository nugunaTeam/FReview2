package com.nuguna.freview.common.vo.experience;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ExperienceStatusCode {
  SENT("SENT"),
  REJECTED("REJECTED"),
  ACCEPTED("ACCEPTED"),
  NOSHOW("NOSHOW"),
  DONE("DONE");

  private final String status;

  public static ExperienceStatusCode from(String status) {
    for (ExperienceStatusCode rs : ExperienceStatusCode.values()) {
      if (rs.getStatus().equalsIgnoreCase(status)) {
        return rs;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 RequestStatus 입력 : " + status);
  }
}