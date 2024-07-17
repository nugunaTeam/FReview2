package com.nuguna.freview.common.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCheckIdRequestDTO {

  @NotBlank(message = "이메일은 필수 항목입니다.")
  private String email;

}
