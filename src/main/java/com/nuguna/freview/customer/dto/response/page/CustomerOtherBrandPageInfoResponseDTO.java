package com.nuguna.freview.customer.dto.response.page;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOtherBrandPageInfoResponseDTO {

  private CustomerBrandInfoResponseDTO brandInfo;
  private List<ReviewLogInfoDTO> reviewInfos;
  private PaginationInfoResponseDTO reviewPaginationInfo;
}
