package com.nuguna.freview.OAuth.service;

import com.nuguna.freview.OAuth.dto.response.GoogleUserInfoDTO;
import java.util.Map;

public interface OAuthService {

  String getLoginFormUrl();

  String getRequestAccessToken(String code);

  GoogleUserInfoDTO getRequestUserInfo(String accessToken);

}
