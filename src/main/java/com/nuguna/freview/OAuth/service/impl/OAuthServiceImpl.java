package com.nuguna.freview.OAuth.service.impl;

import com.nuguna.freview.OAuth.dto.response.GoogleUserInfoDTO;
import com.nuguna.freview.OAuth.service.OAuthService;
import com.nuguna.freview.common.mapper.RegisterMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class OAuthServiceImpl implements OAuthService {

  private final String clientId;
  private final String clientSecret;
  private final String redirectUri;
  private final String tokenEndpoint;
  private final String userInfoEndpoint;

  public OAuthServiceImpl(String clientId, String clientSecret, String redirectUri, String tokenEndpoint, String userInfoEndpoint) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.redirectUri = redirectUri;
    this.tokenEndpoint = tokenEndpoint;
    this.userInfoEndpoint = userInfoEndpoint;
  }

  @Override
  public String getLoginFormUrl() {
    String scope = "https://www.googleapis.com/auth/userinfo.profile";
    String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + clientId
        + "&redirect_uri="+redirectUri+"&response_type=code&scope=email%20profile%20openid&access_type=offline";
    return reqUrl;
  }

  @Override
  public String getRequestAccessToken(String code) {

    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> params = new HashMap<>();

    params.put("code"			, code);
    params.put("client_id"		, clientId);
    params.put("client_secret"	, clientSecret);
    params.put("redirect_uri"	, redirectUri);
    params.put("grant_type"		, "authorization_code");

    Map<String, String> response = restTemplate.postForObject(tokenEndpoint, params, Map.class);
    return response.get("access_token");
  }

  @Override
  public GoogleUserInfoDTO getRequestUserInfo(String accessToken){
    RestTemplate restTemplate = new RestTemplate();
    String url = userInfoEndpoint + "?access_token=" + accessToken;
    GoogleUserInfoDTO userInfo = restTemplate.getForObject(url, GoogleUserInfoDTO.class);
    return userInfo;
  }

}
