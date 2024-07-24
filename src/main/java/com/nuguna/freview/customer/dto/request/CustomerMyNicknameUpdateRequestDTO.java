package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyNicknameUpdateRequestDTO {

  @Min(value = 1, message = "유저 번호는 1번 이상이어야 합니다.")
  private Long userSeq;

  @NotBlank(message = "닉네임은 비어둘 수 없습니다.")
  @Length(min = 1, max = 50, message = "닉네임은 1글자 ~ 50글자 이하여야 합니다.")
  private String toNickname;
}
