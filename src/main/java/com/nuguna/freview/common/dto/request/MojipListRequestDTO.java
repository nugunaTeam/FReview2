package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MojipListRequestDTO {

  private Long previousPostSeq;
  private String searchWord;
}
