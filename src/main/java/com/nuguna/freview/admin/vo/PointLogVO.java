package com.nuguna.freview.admin.vo;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PointLogVO {

  private Long seq;
  private Long userSeq;
  private String code;
  private LocalDateTime createdAt;
}
