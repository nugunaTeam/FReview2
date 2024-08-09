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
public class MainPageRecentGongjiMapperDTO {
  private Long seq;
  private String title;
  private Timestamp createdAt;
  private Timestamp updatedAt;
}
