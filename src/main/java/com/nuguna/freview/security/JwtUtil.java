package com.nuguna.freview.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private String secretKey = "secret";

  // JWT 토큰 생성
  public String createToken(Long userSeq, String userEmail, String role, long tokenValidTime, String businessNumber, String code, String nickname, String profilePhotoUrl, String introduce, String subEmail, String loginType, Boolean isWithDrawn, String ageGroup, String storeLocation) {
    byte[] decoded = Base64.getDecoder().decode(secretKey);
    String decodedSecretKey = new String(decoded);
    Claims claims = Jwts.claims();
    claims.put("userSeq", userSeq);
    claims.put("userEmail", userEmail);
    claims.put("roles", role); // 정보는 key / value 쌍으로 저장된다.
    claims.put("buisnessNumber", businessNumber);
    claims.put("code", code);
    claims.put("nickname", nickname);
    claims.put("profilePhotoUrl", profilePhotoUrl);
    claims.put("introduce", introduce);
    claims.put("subEmail", subEmail);
    claims.put("loginType", loginType);
    claims.put("isWithDrawn", isWithDrawn != null ? isWithDrawn.booleanValue() : null);
    claims.put("ageGroup", ageGroup);
    claims.put("storeLocation", storeLocation);
    claims.put("role", role);
    Date now = new Date();
    return Jwts.builder()
        .setClaims(claims) // 정보 저장
        .setIssuedAt(now) // 토큰 발행 시간 정보
        .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
        .signWith(SignatureAlgorithm.HS512,secretKey)  // 사용할 암호화 알고리즘과
        // signature 에 들어갈 secret값 세팅
        .compact();
  }

  public String getSubject(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().toString();
  }

  public Long getUserSeq(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("userSeq", Long.class);
  }

  public String getUserEmail(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("userEmail", String.class);
  }

  public String getRole(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("roles", String.class);
  }

  public String getBusinessNumber(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("buisnessNumber", String.class);
  }

  public String getCode(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("code", String.class);
  }

  public String getNickname(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("nickname", String.class);
  }

  public String getProfilePhotoUrl(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("profilePhotoUrl", String.class);
  }

  public String getIntroduce(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("introduce", String.class);
  }

  public String getSubEmail(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("subEmail", String.class);
  }

  public String getLoginType(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("loginType", String.class);
  }

  public boolean getIsWithDrawn(String token) {
    Boolean value = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("isWithDrawn", Boolean.class);
    return value != null ? value : false;
  }

  public String getAgeGroup(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("ageGroup", String.class);
  }

  public String getStoreLocation(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("storeLocation", String.class);
  }

  public Boolean isExpired(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
  }


  }


