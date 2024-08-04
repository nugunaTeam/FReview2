package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptedProposalToMeInfoDTO {

  private Long storeSeq;
  private String storeName;
  private String proposalDetails; // TODO: 제안 내용 보여주기
  private String status; // TODO: 'ACCEPTED' => 진행 중, 'NOSHOW' => 노쇼, "DONE" => 체험 완료
  private LocalDate experienceDate; // 체험 날짜
}
