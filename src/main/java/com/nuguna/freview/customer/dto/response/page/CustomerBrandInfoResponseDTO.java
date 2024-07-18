package com.nuguna.freview.customer.dto.response.page;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBrandInfoResponseDTO {

  private String profilePhotoUrl;
  private String nickname;
  private String ageGroup;
  private String introduce;
  private Long zzimCount;
  private List<String> foodTypes;
  private List<String> tagInfos;
}
