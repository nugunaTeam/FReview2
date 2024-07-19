package com.nuguna.freview.customer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPaginationInfoResponseDTO {

  private Integer currentPage;
  private Integer startPage;
  private Integer endPage;
  private Boolean hasNext;
  private Boolean hasPrevious;

}
