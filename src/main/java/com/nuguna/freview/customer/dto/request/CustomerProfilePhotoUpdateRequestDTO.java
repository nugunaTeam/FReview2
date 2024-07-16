package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfilePhotoUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  private String toProfilePhotoUrl;
}
