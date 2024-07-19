package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
  private String email;
  private String password;
  private String subEmail;
  private String nickname;
  private String ageGroup;
  private String code;
  private String storeLocation;
  private String businessNumber;
}
