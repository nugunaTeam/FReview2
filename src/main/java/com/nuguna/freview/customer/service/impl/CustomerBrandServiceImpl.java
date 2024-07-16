package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.mapper.CustomerBrandMapper;
import com.nuguna.freview.customer.service.CustomerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBrandServiceImpl implements CustomerBrandService {

  private final CustomerBrandMapper customerBrandMapper;

  @Autowired
  public CustomerBrandServiceImpl(CustomerBrandMapper customerBrandMapper) {
    this.customerBrandMapper = customerBrandMapper;
  }
}
