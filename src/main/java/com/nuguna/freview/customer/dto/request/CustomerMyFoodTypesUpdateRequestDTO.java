package com.nuguna.freview.customer.dto.request;

import com.nuguna.freview.customer.validation.annotation.ValidFoodTypes;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyFoodTypesUpdateRequestDTO {

  @ValidFoodTypes
  @NotNull(message = "활동 분야 관련 입력은 필수 값입니다.")
  @Size(max = 5, message = "활동 분야는 최대 5개까지 선택할 수 있습니다.")
  private List<String> toFoodTypes;
}
