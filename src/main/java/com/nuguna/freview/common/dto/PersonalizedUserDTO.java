package com.nuguna.freview.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonalizedUserDTO {
  private Long userSeq;
  private String email;
  private String nickname;
  private String profilePhotoUrl;
  private String foodTypeWord;
  private String tagWord;
}
