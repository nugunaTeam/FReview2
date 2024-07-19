package com.nuguna.freview.customer.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReviewPaginationInfoResponseDTO {

  private Integer currentPage;
  private Integer startPage;
  private Integer endPage;
  private Boolean hasNext;
  private Boolean hasPrevious;

  public ReviewPaginationInfoResponseDTO(Integer currentPage, Integer startPage, Integer endPage) {
    this.currentPage = currentPage;
    this.startPage = startPage;
    this.endPage = endPage;
    this.hasNext = currentPage < endPage;
    this.hasPrevious = currentPage > startPage;
  }

}
