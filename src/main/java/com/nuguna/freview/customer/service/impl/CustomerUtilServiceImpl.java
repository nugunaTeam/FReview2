package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.customer.mapper.CustomerUtilMapper;
import com.nuguna.freview.customer.service.CustomerUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerUtilServiceImpl implements CustomerUtilService {

  private final CustomerUtilMapper customerUtilMapper;

  @Autowired
  public CustomerUtilServiceImpl(CustomerUtilMapper customerUtilMapper) {
    this.customerUtilMapper = customerUtilMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public String getUserNickname(Long userSeq) {
    return customerUtilMapper.getUserNickname(userSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkZzimedOtherUser(Long fromUserSeq, Long toUserSeq) {
    return customerUtilMapper.checkZzimedOtherUser(fromUserSeq, toUserSeq);
  }
}
