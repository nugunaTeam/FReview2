package com.nuguna.freview.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OtherBrandPageUtilMapper {

  String getUserNickname(Long userSeq);
  String getStoreName(Long userSeq);
  Boolean checkUserIsStore(Long userSeq);

  Boolean checkZzimedOtherUser(@Param("fromUserSeq") Long fromUserSeq,
      @Param("toUserSeq") Long toUserSeq);

  Boolean checkStoreProposedToUser(@Param("storeSeq") Long storeSeq,
      @Param("customerSeq") Long customerSeq);

  String getUserCode(@Param("userSeq") Long userSeq);
}
