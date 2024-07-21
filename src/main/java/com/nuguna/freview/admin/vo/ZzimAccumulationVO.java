package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ZzimAccumulationVO {
  private Long userSeq;
  private Long totalZzim;

  public void updateTotalZzim(Long newTotal) {
    this.totalZzim = newTotal;
  }
}
