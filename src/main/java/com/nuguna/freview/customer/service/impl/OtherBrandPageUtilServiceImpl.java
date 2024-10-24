package com.nuguna.freview.customer.service.impl;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.customer.mapper.OtherBrandPageUtilMapper;
import com.nuguna.freview.customer.service.OtherBrandPageUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OtherBrandPageUtilServiceImpl implements OtherBrandPageUtilService {

  private final OtherBrandPageUtilMapper otherBrandPageUtilMapper;

  @Autowired
  public OtherBrandPageUtilServiceImpl(OtherBrandPageUtilMapper otherBrandPageUtilMapper) {
    this.otherBrandPageUtilMapper = otherBrandPageUtilMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public String getUserNickname(Long userSeq) {
    return otherBrandPageUtilMapper.getUserNickname(userSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public String getStoreName(Long userSeq) {
    return otherBrandPageUtilMapper.getStoreName(userSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkUserIsStore(Long userSeq) {
    return otherBrandPageUtilMapper.checkUserIsStore(userSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public UserCode getUserCode(Long userSeq) {
    return UserCode.from(otherBrandPageUtilMapper.getUserCode(userSeq));
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkZzimedOtherUser(Long fromUserSeq, Long toUserSeq) {
    return otherBrandPageUtilMapper.checkZzimedOtherUser(fromUserSeq, toUserSeq);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean checkStoreProposedToUser(Long storeSeq, Long customerSeq) {
    return otherBrandPageUtilMapper.checkStoreProposedToUser(storeSeq, customerSeq);
  }
}
