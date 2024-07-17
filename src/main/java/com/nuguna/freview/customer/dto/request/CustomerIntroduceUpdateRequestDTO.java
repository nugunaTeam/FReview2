package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIntroduceUpdateRequestDTO {

  @Min(1)
  private Long userSeq;
  @Size(max = 100, message = "소개글은 100글자까지 작성 가능합니다.")
  private String toIntroduce;
}
