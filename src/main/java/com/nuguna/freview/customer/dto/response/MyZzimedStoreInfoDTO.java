package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyZzimedStoreInfoDTO {

  private Long storeSeq;

  private String storeName;

  private String storeLocation;

  private List<String> foodTypes;

  private LocalDate createdAt;

}
