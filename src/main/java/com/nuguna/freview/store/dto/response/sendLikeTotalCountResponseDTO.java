package com.nuguna.freview.store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class sendLikeTotalCountResponseDTO {
  private Long userSeq;
  private Integer totalCount;
}
