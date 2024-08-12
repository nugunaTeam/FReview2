package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimedMeStoreInfoDTO {

  private Long notificationSeq;
  private Long storeSeq;
  private String storeName;
  private LocalDate createdAt;

}
