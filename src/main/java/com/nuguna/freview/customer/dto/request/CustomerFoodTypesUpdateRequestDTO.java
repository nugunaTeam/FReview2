package com.nuguna.freview.customer.dto.request;

import java.util.List;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFoodTypesUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  private List<String> toFoodTypes;
}
