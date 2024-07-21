package com.nuguna.freview.admin.dto;

import lombok.Getter;

@Getter
public class ExperienceLogDTO {

  private Long seq;
  private Long fromUserSeq;
  private Long toUserSeq;
  private Long fromPostSeq;
  private String status;
}
