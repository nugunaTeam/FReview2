package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyProfilePhotoUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
}
