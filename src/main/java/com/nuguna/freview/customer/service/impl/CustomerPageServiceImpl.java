package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.mapper.CustomerPageMapper;
import com.nuguna.freview.customer.service.CustomerPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerPageServiceImpl implements CustomerPageService {

  private final CustomerPageMapper customerPageMapper;

  @Autowired
  public CustomerPageServiceImpl(CustomerPageMapper customerPageMapper) {
    this.customerPageMapper = customerPageMapper;
  }

  @Override
  public CustomerMyBrandPageInfoResponseDTO getBrandPageInfo(Long userSeq) {
    return customerPageMapper.getCustomerBrandPageInfo(userSeq);
  }
}
