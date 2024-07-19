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

  private CustomerBrandInfoResponseDTO brandInfo;
  private List<ReviewLogInfoDTO> reviewInfos;
}
