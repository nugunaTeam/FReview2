package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationReceivedZzimResponseDTO {
  private Long userSeq;
  private Long zzimUserSeq;
  private String code;
  private Timestamp createdAt;
  private Long zzimCount;

}
