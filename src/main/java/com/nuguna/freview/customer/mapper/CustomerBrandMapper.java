package com.nuguna.freview.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerBrandMapper {

  Boolean checkNicknameExist(@Param("toNickname") String toNickname,
      @Param("userSeq") Long userSeq);

  void updateNickname(@Param("userSeq") Long userSeq, @Param("toNickname") String toNickname);

  void updateAgeGroup(@Param("userSeq") Long userSeq, @Param("toAgeGroup") String toAgeGroup);

}
