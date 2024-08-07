package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeAccumulationVO {

  private Long postSeq;
  private Long totalLike;

  public void updateTotalLike(Long newTotalLike) {
    if (totalLike < 0) {
      throw new IllegalArgumentException("[ERROR] -" + postSeq +"- 누적 좋아요 개수가 0 미만입니다.");
    }
    this.totalLike = newTotalLike;
  }
}
