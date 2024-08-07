package com.nuguna.freview.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerUtilMapper {

  String getUserNickname(Long userSeq);

  Boolean checkUserIsStore(Long userSeq);

  Boolean checkZzimedOtherUser(@Param("fromUserSeq") Long fromUserSeq,
      @Param("toUserSeq") Long toUserSeq);

  Boolean checkStoreProposedToUser(@Param("storeSeq") Long storeSeq,
      @Param("customerSeq") Long customerSeq);

}
