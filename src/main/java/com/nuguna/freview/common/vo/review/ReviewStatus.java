package com.nuguna.freview.common.vo.review;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ReviewStatus {
  UNWRITTEN("UNWRITTEN"),
  WRITTEN("WRITTEN"),
  NOSHOW("NOSHOW"),
  STORE_HIDDEN("STORE_HIDDEN");

  private final String status;

  ReviewStatus(String status) {
    this.status = status;
  }

  public static ReviewStatus from(String status) {
    for (ReviewStatus rs : ReviewStatus.values()) {
      if (rs.getStatus().equalsIgnoreCase(status)) {
        return rs;
      }
    }
    throw new IllegalArgumentException("유효하지 않은 ReviewStatus 입력 : " + status);
  }
}
