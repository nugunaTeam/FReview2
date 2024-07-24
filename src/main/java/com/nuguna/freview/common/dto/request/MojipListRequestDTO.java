package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MojipListRequestDTO {

  private Long requesterSeq;
  private Long previousPostSeq;
  private String searchWord;
}
