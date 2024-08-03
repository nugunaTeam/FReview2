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
  private Long proposalDetails; //  모집글 seq TODO:  ( 뷰 구현시 참고 :  모집글 보러가기 버튼 누르면 해당 모집글로 이동 )
  private String status; // TODO: 'ACCEPTED' => 진행 중, 'NOSHOW' => 노쇼, "DONE" => 체험 완료
  private LocalDate experienceDate; // 체험 날짜
}
