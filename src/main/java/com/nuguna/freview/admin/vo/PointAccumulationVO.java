package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PointAccumulationVO {

  private Long userSeq;
  private Long totalPoint;

  public void updateTotalPoint(Long newTotalPoint) {
    if (totalPoint < 0) {
      throw new IllegalArgumentException("[ERROR] -" + userSeq +"- 누적 포인트 점수가 0 미만입니다.");
    }
    this.totalPoint = newTotalPoint;
  }
}
