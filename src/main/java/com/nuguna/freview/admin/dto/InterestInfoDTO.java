package com.nuguna.freview.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterestInfoDTO {

  private Long userSeq;
  private String category;
  private String dish;
  private int total_score;
}
