package com.nuguna.freview.security.jwtfilter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
  //CustomAccessDeniedHandler는 인증된 사용자가 접근 권한이 없는 리소스에 접근하려고 할 때 처리합니다. 여기서는 403 Forbidden 응답을 반환하도록 합니다.
  @Override
  public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      AccessDeniedException e) throws IOException, ServletException {
    log.info("Access denied");
    httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
  }
}
