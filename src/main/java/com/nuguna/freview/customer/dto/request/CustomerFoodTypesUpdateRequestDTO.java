package com.nuguna.freview.customer.dto.request;

import com.nuguna.freview.customer.validation.annotation.ValidFoodTypes;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFoodTypesUpdateRequestDTO {

  @Min(1)
  private Long userSeq;

  @ValidFoodTypes
  @Size(max = 5, message = "활동 분야는 최대 5개까지 선택할 수 있습니다.")
  private List<String> toFoodTypes;
}
