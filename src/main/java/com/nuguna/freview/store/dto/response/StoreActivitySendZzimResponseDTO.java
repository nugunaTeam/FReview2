package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivitySendZzimResponseDTO {
  private Long userSeq;
  private Long toUserSeq;
  private String nickname;
  private String code;
  private Long zzimCount;
  private Timestamp createdAt;

}
