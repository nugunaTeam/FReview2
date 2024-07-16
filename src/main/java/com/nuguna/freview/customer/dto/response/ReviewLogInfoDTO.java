package com.nuguna.freview.customer.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewLogInfoDTO {

  private String reviewStatus;
  private String storeName;
  private Timestamp visitDate;
  private String reviewUrl;

}