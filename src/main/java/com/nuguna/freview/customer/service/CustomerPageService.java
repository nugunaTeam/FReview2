package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerOtherPageInfoResponseDTO;

public interface CustomerPageService {

  CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq);

  CustomerOtherPageInfoResponseDTO getOtherBrandPageInfo(Long userSeq);

}
