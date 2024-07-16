package com.nuguna.freview.customer.service;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;

public interface CustomerPageService {

  CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq);

}
