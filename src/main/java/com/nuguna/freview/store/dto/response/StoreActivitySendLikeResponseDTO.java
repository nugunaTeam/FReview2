package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivitySendLikeResponseDTO {
  private Long userSeq;
  private Long writtenSeq;
  private Long postSeq;
  private String postCode;
  private String title;
  private String content;
  private Long likeCount;
  private Timestamp createdAt;

}
