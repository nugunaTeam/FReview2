package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreApplyListDTO {
  private Long experienceSeq;
  private Long fromPostSeq;
  private Long fromUserSeq;
  private String nickname;
  private String title;
  private String status;
  private Timestamp applyStartDate;
  private Timestamp applyEndDate;
  private Timestamp experienceDate;
  private Timestamp createdAt;

}
