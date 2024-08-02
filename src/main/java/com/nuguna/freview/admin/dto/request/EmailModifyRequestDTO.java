package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailModifyRequestDTO {

  private String newEmail;
  private Long userSeq;
}
