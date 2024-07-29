package com.nuguna.freview.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestAccumulationDTO {

  private Long userSeq;
  private String dish;
  private String category;
  private int totalScore;
}
