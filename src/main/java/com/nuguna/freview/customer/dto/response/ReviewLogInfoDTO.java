package com.nuguna.freview.customer.dto.response;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewLogInfoDTO {

  private Long seq;
  private Long storeSeq;
  private String storeName;
  private String status;
  private String url;
  private Date visitDate;
  private Date createdAt;

}