package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfilePhotoUpdateRequestDTO {

  @Min(1)
  private Long userSeq;

  @NotNull(message = "프로필 사진 관련 입력은 필수 값입니다.")
  private String toProfilePhotoUrl;
}
