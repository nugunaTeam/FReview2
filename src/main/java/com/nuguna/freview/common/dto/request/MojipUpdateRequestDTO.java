package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MojipUpdateRequestDTO {

  private Long postSeq;
  private String title;
  private String content;
}
