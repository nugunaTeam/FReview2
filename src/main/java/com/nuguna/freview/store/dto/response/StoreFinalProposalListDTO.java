package com.nuguna.freview.store.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreFinalProposalListDTO {
  private Long experienceSeq;
  private Long toUserSeq;
  private String proposalDetail;
  private String nickname;
  private String status;
  private LocalDate experienceDate;
}
