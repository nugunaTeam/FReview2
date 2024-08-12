package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ZzimAccumulationVO {
  private Long userSeq;
  private Long totalZzim;

  public void updateTotalZzim(Long newTotal) {
    if (totalZzim < 0) {
      throw new IllegalArgumentException("[ERROR] -" + userSeq +"- 누적 찜 개수가 0 미만입니다.");
    }
    this.totalZzim = newTotal;
  }
}
