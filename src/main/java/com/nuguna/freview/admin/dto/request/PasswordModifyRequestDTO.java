package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordModifyRequestDTO {
  private String oldPassword;
  private String newPassword;
  private Long userSeq;
}
