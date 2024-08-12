package com.nuguna.freview.common.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimRequestDTO {

  @Min(1)
  @NotNull
  private Long toUserSeq;
}
