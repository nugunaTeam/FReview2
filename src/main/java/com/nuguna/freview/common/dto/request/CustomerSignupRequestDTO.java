package com.nuguna.freview.common.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CustomerSignupRequestDTO {

  @NotBlank(message = "이메일은 필수 항목입니다.")
  private String email;

  //  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
  @NotBlank(message = "비밀번호는 필수 항목입니다.")
  private String password;

  @NotBlank(message = "유저 코드는 필수 항목입니다.")
  @Pattern(regexp = "CUSTOMER", message = "유효하지 않은 유저 코드입니다.")
  private String code;

  @NotBlank(message = "닉네임은 필수 항목입니다.")
  private String nickname;

  @NotBlank(message = "로그인 타입은 필수 항목입니다.")
  private String loginType;

  @NotBlank(message = "연령대는 필수 항목입니다.")
  private String ageGroup;

  @NotBlank(message = "서브 이메일은 필수 항목입니다.")
  private String subEmail;

}
