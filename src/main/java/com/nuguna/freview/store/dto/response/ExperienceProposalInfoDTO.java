package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceProposalInfoDTO {
  private Long userSeq;
  private Long proposalUserSeq;
  private String nickname;
  private String status;
  private String proposalDetail;
  private Timestamp createdAt;
}
