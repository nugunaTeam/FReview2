package com.nuguna.freview.store.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreOtherReviewLogInfoDTO {

  private Long seq;
  private Long customerSeq;
  private String customerNickname;
  private String status;
  private String url;
  private LocalDate visitDate;
  private LocalDate createdAt;
}
