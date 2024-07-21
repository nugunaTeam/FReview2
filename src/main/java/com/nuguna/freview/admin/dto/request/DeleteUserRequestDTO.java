package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRequestDTO {

  private Long adminSeq;
  private String adminVerificationPW;
}
