package com.nuguna.freview.customer.service;

public interface OtherBrandPageUtilService {

  String getUserNickname(Long userSeq);

  String getStoreName(Long userSeq);

  boolean checkUserIsStore(Long userSeq);

  boolean checkZzimedOtherUser(Long fromUserSeq, Long toUserSeq);

  boolean checkStoreProposedToUser(Long storeSeq, Long customerSeq);
  
}
