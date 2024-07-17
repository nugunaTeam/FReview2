package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReviewRegisterRequestDTO {

  @Min(1)
  private Long userSeq;
  @NotBlank(message = "리뷰 URL은 비어있는 값이면 안됩니다.")
  private String reviewUrl;
}
