package com.nuguna.freview.admin.vo;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class LikeLogVO {

  private Long seq;
  private Long postSeq;
  private Long userSeq;
  private String code;
  private Timestamp createdAt;
}
