package com.nuguna.freview.common.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationFilteringRequestDTO {

  private Long previousUserSeq;
  private List<String> foodTypes;
  private List<String> tags;
  private String userCode;
}
