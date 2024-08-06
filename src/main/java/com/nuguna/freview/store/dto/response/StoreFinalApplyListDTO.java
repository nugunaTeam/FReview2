package com.nuguna.freview.store.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreFinalApplyListDTO {
  private Long fromUserSeq;
  private String title;
  private String nickname;
  private Timestamp experienceDate;
  private String status;
}
