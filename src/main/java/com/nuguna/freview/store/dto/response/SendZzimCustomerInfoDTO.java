package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendZzimCustomerInfoDTO {
  private Long zzimUserSeq;
  private String nickname;
  private String foodTypes;
}
