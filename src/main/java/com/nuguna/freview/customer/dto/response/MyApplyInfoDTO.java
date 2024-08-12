package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyApplyInfoDTO {

  private Long storeSeq;
  private String storeName;
  private Long postSeq;
  private String status;
  private LocalDate applyDate;
}
