package com.nuguna.freview.admin.dto.response.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProfileDTO {

  private Long seq;
  private String email;
  private String password;
  private String nickname;
  private String subEmail;
}
