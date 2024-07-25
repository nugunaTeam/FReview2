package com.nuguna.freview.admin.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoneExperienceDTO {

  private LocalDate date;
  private Long totalDone;
}
