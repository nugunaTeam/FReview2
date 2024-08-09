package com.nuguna.freview.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainPageCustomerMapperDTO {
  private Long seq;
  private String profilePhotoUrl;
  private String nickname;
}
