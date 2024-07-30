package com.nuguna.freview.customer.dto.response;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyLikePostInfoDTO {

  private Long seq;
  private Long authorSeq; // store임.
  private String storeName;
  private String title;
  private String content;
  private Integer likeCount;
  private Date createdAt;

}
