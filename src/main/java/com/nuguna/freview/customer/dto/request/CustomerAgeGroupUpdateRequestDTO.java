package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAgeGroupUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  @NotBlank
  private String toAgeGroup;
}
