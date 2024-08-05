package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.dto.response.page.CustomerOtherBrandPageInfoResponseDTO;

public interface CustomerPageService {

  String getCustomerNickname(Long customerSeq);

  CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq);

  CustomerOtherBrandPageInfoResponseDTO getOtherBrandPageInfo(Long userSeq);

}
