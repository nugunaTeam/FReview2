package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReceivedLikeInfoDTO {

  private Long userSeq;
  private Long postSeq;
  private String postCode;
  private String title;
  private String content;
  private Long writtenSeq;
  private Timestamp createdAt;
  private Long likeCount;

}
