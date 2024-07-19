package com.nuguna.freview.common.dto.request;

import com.nuguna.freview.common.CannotZzimMyself;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@CannotZzimMyself
@NoArgsConstructor
@AllArgsConstructor
public class ZzimRequestDTO {

  @Min(1)
  @NotNull
  private Long userSeq;

  @Min(1)
  @NotNull
  private Long toUserSeq;
}
