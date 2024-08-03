package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyApplyInfoDTO {

  private Long storeSeq;
  private String storeName;
  private Long postSeq; //  모집글 seq TODO:  ( 뷰 구현시 참고 :  모집글 보러가기 버튼 누르면 해당 모집글로 이동 )
  private LocalDate applyDate; // 내가 지원한 날짜
  private String status; // TODO: SENT => "지원 중" (초록 버튼), REJECTED => "거절됨" (회색 버튼)
}
