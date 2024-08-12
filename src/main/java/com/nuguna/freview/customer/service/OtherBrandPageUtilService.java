package com.nuguna.freview.customer.service;

import com.nuguna.freview.common.vo.user.UserCode;

public interface OtherBrandPageUtilService {

  String getUserNickname(Long userSeq);

  String getStoreName(Long userSeq);

  UserCode getUserCode(Long userSeq);

  boolean checkUserIsStore(Long userSeq);

  boolean checkZzimedOtherUser(Long fromUserSeq, Long toUserSeq);

  boolean checkStoreProposedToUser(Long storeSeq, Long customerSeq);
  
}
