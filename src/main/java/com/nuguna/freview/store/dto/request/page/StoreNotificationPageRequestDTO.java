package com.nuguna.freview.store.dto.request.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreNotificationPageRequestDTO {
  private Long userSeq;
  private String code;
}
