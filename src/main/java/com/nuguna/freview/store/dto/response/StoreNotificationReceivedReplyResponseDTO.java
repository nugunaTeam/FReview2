package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationReceivedReplyResponseDTO {
  private Long userSeq;
  private Long postSeq;
  private String title;
  private String content;
  private Timestamp createdAt;

}
