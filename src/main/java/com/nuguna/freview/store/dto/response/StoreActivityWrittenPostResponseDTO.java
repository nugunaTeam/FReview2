package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivityWrittenPostResponseDTO {
  private Long userSeq;
  private String title;
  private String content;
  private Timestamp experienceDate;
  private Timestamp createdAt;
  private Long likeCount;

}
