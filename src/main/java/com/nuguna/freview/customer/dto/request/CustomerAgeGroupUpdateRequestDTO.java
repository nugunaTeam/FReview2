package com.nuguna.freview.customer.dto.request;

import com.nuguna.freview.customer.validation.annotation.ValidAgeGroup;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAgeGroupUpdateRequestDTO {

  @Min(1)
  private Long userSeq;

  @NotBlank
  @ValidAgeGroup
  private String toAgeGroup;
}
