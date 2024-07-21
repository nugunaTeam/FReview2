package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationReceivedLikeResponseDTO {
  private Long userSeq;
  private Long postSeq;
  private String title;
  private String content;
  private Long writtenSeq;
  private Timestamp createdAt;
  private Long likeCount;

}
