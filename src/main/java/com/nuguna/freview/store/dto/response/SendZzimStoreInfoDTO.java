package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendZzimStoreInfoDTO {
  private Long zzimUserSeq;
  private String nickname;
  private String storeLocation;
  private String foodTypes;
}
