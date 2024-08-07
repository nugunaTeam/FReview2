package com.nuguna.freview.OAuth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleUserRegistRequestDTO {
  private String email;
  private String subEmail;
  private String nickname;
  private String ageGroup;
  private String code;
  private String storeLocation;
  private String businessNumber;
}
