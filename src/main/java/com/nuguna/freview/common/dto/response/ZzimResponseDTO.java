package com.nuguna.freview.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZzimResponseDTO {

  private Boolean zzimed; // 클라이언트가 현재 보고 있는 스토어/체험단을 찜했는지 안했는지 여부
  private Long zzimCount; // 클라이언트가 현재 보고 있는 스토어/체험단 브랜딩 페이지의 찜 개수
}
