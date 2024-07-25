package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.mapper.CustomerUtilMapper;
import com.nuguna.freview.customer.service.CustomerUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerUtilServiceImpl implements CustomerUtilService {

  private final CustomerUtilMapper customerUtilMapper;

  @Autowired
  public CustomerUtilServiceImpl(CustomerUtilMapper customerUtilMapper) {
    this.customerUtilMapper = customerUtilMapper;
  }

  @Override
  public String getUserNickname(Long userSeq) {
    return customerUtilMapper.getUserNickname(userSeq);
  }
}
