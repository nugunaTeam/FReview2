package com.nuguna.freview.common.dto.request;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MojipInsertRequestDTO {

  private Long userSeq;
  private String title;
  private Timestamp applyStartDate;
  private Timestamp applyEndDate;
  private Timestamp experienceDate;
  private String content;
}
