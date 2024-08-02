package com.nuguna.freview.customer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfoResponseDTO {

  private Integer currentPage;
  private Integer startPage;
  private Integer endPage;
  private Boolean hasNext;
  private Boolean hasPrevious;

}
