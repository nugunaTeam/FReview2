package com.nuguna.freview.common.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeListDTO {

  private Long seq;
  private Long userSeq;
  private String title;
  private String content;
  private Timestamp createdAt;
  private int viewCount;
}
