package com.nuguna.freview.customer.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyReviewsRetrieveRequestDTO {
  // My 로 강조한 이유는, 체험단의 브랜딩 수정 페이지에서의 요청임을 강조
  // 이 때는 NOSHOW 상태의 리뷰도 보여줘야 함.
  // 추후 다른 유저가 해당 체험단의 리뷰를 보기 위한 ReviewsRetrieveRequestDTO를 통해서는
  // NOSHOW 상태의 리뷰를 조회할 수 없음.

  @Min(1)
  @NotNull
  private Long userSeq;

  @Min(1)
  @NotNull
  private Integer page;

}
