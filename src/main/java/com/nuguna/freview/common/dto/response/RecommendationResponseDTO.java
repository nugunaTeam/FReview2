package com.nuguna.freview.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponseDTO {

  private Long userSeq;
  private String email;
  private String nickname;
  private String profilePhotoUrl;
  private String foodTypeWord;
  private String tagWord;
}
