package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProposalListDTO {
  private Long toUserSeq;
  private String nickname;
  private String proposalDetail;
  private Timestamp createdAt;
  private String status;
}
