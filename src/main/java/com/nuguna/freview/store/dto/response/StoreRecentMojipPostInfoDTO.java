package com.nuguna.freview.store.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRecentMojipPostInfoDTO {

  private Long seq;
  private String title;
  private LocalDate createdAt;
}
