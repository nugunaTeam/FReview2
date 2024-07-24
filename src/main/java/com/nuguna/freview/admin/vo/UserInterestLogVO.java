package com.nuguna.freview.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInterestLogVO {
  private Long seq;
  private Long userSeq;
  private String code;
  private String category;
  private String dish;
  private String createdAt;
}
