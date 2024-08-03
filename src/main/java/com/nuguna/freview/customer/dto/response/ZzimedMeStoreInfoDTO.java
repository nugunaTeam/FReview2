package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimedMeStoreInfoDTO {

  // EX MESSAGE : "${storeName}" 님이 나를 찜하였습니다.
  private Long storeSeq;
  private String storeName;
  private LocalDate createdAt;

}
