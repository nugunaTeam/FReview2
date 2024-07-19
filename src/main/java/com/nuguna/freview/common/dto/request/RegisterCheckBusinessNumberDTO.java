package com.nuguna.freview.common.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCheckBusinessNumberDTO {
  @NotBlank(message = "이메일은 필수 항목입니다.")
  private String buisnessNumber;
}
