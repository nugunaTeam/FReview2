package com.nuguna.freview.common.dto.response;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainPageRecentGongjiSimpleDateDTO {

  private Long seq;
  private String title;
  private String createdAt;
  private String updatedAt;

}
