package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCustomerRequestDTO {

  private Long deleteUserSeq;
  private Long adminSeq;
  private String adminVerificationPW;
}
