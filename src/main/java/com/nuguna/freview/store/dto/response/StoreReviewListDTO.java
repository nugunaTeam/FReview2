package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreReviewListDTO {
  private Long seq;
  private Long customerSeq;
  private Long experienceSeq;
  private Timestamp visitDate;
  private String nickname;
  private String status;
  private String url;
  private Timestamp createdAt;
}
