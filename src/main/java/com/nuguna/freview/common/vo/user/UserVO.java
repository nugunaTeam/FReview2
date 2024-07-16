package com.nuguna.freview.common.vo.user;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserVO {

  private Long seq;
  private String businessNumber;
  private String code;
  private String email;
  private String password;
  private String nickname;
  private String profilePhotoUrl;
  private String introduce;
  private String subEmail;
  private String loginType;
  private Boolean isWithDrawn;
  private String ageGroup;
  private String storeLocation;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
