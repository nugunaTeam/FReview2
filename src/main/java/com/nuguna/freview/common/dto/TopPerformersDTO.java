package com.nuguna.freview.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopPerformersDTO {
  private Long userSeq;
  private String nickname;
  private int totalPoint;
}
