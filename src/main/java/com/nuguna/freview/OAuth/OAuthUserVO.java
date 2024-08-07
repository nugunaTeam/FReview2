package com.nuguna.freview.OAuth;

import com.nuguna.freview.common.vo.user.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthUserVO {
  private UserVO uservo;
  private String role;
}
