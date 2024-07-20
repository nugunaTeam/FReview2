package com.nuguna.freview.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeInsertRequestDTO {

  private Long userSeq;
  private String title;
  private String content;
}
