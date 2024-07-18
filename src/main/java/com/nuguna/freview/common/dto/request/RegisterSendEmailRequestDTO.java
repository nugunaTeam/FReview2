package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSendEmailRequestDTO {

  private String email;
  private String randomNumber;

}
