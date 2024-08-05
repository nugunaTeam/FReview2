package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StorePaginationInfoResponseDTO {

  private Integer currentPage;
  private Integer startPage;
  private Integer endPage;
  private Boolean hasNext;
  private Boolean hasPrevious;

}
