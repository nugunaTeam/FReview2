package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivitySendZzimStoreResponseDTO {
  private Long userSeq;
  private Long zzimUserSeq;
  private String nickname;
  private String code;
  private String storeLocation;
  private String foodTypes;
}
