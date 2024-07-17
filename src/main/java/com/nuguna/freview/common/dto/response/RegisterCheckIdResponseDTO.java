package com.nuguna.freview.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterCheckIdResponseDTO {
  private boolean checkDuplicatedId;
}
