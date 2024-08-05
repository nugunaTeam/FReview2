package com.nuguna.freview.admin.dto.response.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterestStatsResponseDTO {

  private String code;
  private String category;
  private int totalScore;
}
