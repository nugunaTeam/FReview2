package com.nuguna.freview.admin.vo;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdminVO {

  private Long seq;
  private String code;
  private String email;
  private String password;
  private String nickname;
  private String subEmail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
