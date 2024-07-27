package com.nuguna.freview.customer.service;

public interface CustomerUtilService {

  String getUserNickname(Long userSeq);

  boolean checkZzimedOtherUser(Long fromUserSeq, Long toUserSeq);

}
