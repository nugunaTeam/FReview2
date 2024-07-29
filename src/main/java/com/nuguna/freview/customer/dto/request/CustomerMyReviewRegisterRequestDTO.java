package com.nuguna.freview.customer.dto.request;

import com.nuguna.freview.customer.validation.annotation.ValidUrl;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyReviewRegisterRequestDTO {

  @Min(1)
  private Long userSeq;

  @Min(1)
  @NotNull
  private Long reviewSeq;

  @ValidUrl
  @NotBlank(message = "리뷰 URL은 비어있는 값이면 안됩니다.")
  private String reviewUrl;
}
