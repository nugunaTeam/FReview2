package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyIntroduceUpdateRequestDTO {

  @Min(1)
  private Long userSeq;

  @NotNull(message = "소개글 관련 입력은 필수 값입니다.")
  @Length(max = 100, message = "소개글은 100글자까지 작성 가능합니다.")
  private String toIntroduce;
}
