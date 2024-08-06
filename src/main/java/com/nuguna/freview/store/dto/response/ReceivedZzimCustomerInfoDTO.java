package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedZzimCustomerInfoDTO {
  private Long userSeq;
  private Long zzimUserSeq;
  private String nickname;
  private String code;
  private String foodTypes;

}
