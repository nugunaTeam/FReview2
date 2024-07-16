package com.nuguna.freview.customer.dto.response.page;

import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMyBrandPageInfoResponseDTO {

  private String profilePhotoUrl;
  private String nickname;
  private String ageGroup;
  private String introduce;
  private Long zzimCount;
  private List<String> foodTypes;
  private List<String> tagInfos;
  private List<ReviewLogInfoDTO> reviewInfos;

}
