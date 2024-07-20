package com.nuguna.freview.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeUpdateRequestDTO {

  private Long seq;
  private String title;
  private String content;
}
