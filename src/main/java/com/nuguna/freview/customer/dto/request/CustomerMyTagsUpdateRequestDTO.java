package com.nuguna.freview.customer.dto.request;

import com.nuguna.freview.customer.validation.annotation.ValidCustomerTags;
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
public class CustomerMyTagsUpdateRequestDTO {

  @Min(1)
  private Long userSeq;

  @ValidCustomerTags
  @NotNull(message = "태그 관련 입력은 필수 값입니다.")
  @Size(max = 2, message = "태그는 최대 2개까지 선택할 수 있습니다.")
  private List<String> toTags;
}
