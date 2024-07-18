package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRequestDTO {

  private Long adminSeq;
  private String adminVerificationPW;
}
