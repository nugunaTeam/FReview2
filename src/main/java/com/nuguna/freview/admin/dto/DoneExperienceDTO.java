package com.nuguna.freview.admin.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoneExperienceDTO {

  private LocalDate date;
  private Long totalDone;
}
