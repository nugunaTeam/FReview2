package com.nuguna.freview.customer.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyLikePostInfoDTO {

  private Long seq;
  private Long authorSeq;
  private LocalDate createdAt;
  private String storeName;
  private Integer likeCount;

}
