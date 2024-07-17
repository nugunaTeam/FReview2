package com.nuguna.freview.admin.vo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {

  private Long seq;
  private String code;
  private String email;
  private String password;
  private String nickname;
  private String profilePhotoUrl;
  private String subEmail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
