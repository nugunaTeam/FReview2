package com.nuguna.freview.customer.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOtherReviewsRetrieveResponseDTO {

  private List<ReviewLogInfoDTO> reviewInfos;
  private PaginationInfoResponseDTO reviewPageInfo;
}
