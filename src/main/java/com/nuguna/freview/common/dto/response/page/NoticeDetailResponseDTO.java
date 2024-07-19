package com.nuguna.freview.common.dto.response.page;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDetailResponseDTO {

  private Long seq;
  private Long userSeq;
  private String title;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private String content;
  private int viewCount;
}
