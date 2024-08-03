package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalToMeInfoDTO {

  private Long storeSeq;
  private String storeName;
  private String proposalDetails; //  모집글 seq TODO:  ( 뷰 구현시 참고 :  모집글 보러가기 버튼 누르면 해당 모집글로 이동 )
  private String status;  // 상태 보여준다. TODO: ( SENT => 수락, 거절 버튼  | REJECTED => 거절함 ( 회색 버튼 ) )
  private LocalDate proposalDate; // 제안이 온 날짜

}
