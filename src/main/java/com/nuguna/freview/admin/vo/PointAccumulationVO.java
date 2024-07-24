package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PointAccumulationVO {

  private Long userSeq;
  private Long totalPoint;

  public void updateTotalPoint(Long newTotalPoint) {
    this.totalPoint = newTotalPoint;
  }
}
