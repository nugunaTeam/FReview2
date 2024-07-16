package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIntroduceUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  private String toIntroduce;
}
