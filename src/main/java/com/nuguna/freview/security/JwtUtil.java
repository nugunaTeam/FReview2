package com.nuguna.freview.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

  private String secretKey = "secret";

  // JWT 토큰 생성
  public String createToken(Long userSeq, String userEmail, String role, long tokenValidTime) {
    byte[] decoded = Base64.getDecoder().decode(secretKey);
    String decodedSecretKey = new String(decoded);
    Claims claims = Jwts.claims();
    claims.put("userSeq", userSeq);
    claims.put("userEmail", userEmail);
    claims.put("roles", role); // 정보는 key / value 쌍으로 저장된다.
    Date now = new Date();
    return Jwts.builder()
        .setClaims(claims) // 정보 저장
        .setIssuedAt(now) // 토큰 발행 시간 정보
        .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
        .signWith(SignatureAlgorithm.HS512,secretKey)  // 사용할 암호화 알고리즘과
        // signature 에 들어갈 secret값 세팅
        .compact();
  }

}
