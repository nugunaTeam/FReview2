package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProposalListDTO {
  private Long toUserSeq;
  private String nickname;
  private String experience_detail;
  private Timestamp createdAt;
  private String status;
}
