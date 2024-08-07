package com.nuguna.freview.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HiddenReviewDTO {
  private Long seq;
  private Long storeSeq;
  private String storeName;
  private Long reviewerSeq;
  private String reviewerName;
  private String url;
}
