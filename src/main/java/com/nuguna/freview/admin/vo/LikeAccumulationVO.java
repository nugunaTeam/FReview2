package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeAccumulationVO {

  private Long postSeq;
  private Long totalLike;

  public void updateTotalLike(Long newTotalLike) {
    this.totalLike = newTotalLike;
  }
}
