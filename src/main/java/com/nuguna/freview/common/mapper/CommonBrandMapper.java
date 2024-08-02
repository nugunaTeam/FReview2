package com.nuguna.freview.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonBrandMapper {

  Boolean isZzimed(@Param("fromUserSeq") Long fromUserSeq, @Param("toUserSeq") Long toUserSeq);

  void deleteZzim(@Param("fromUserSeq") Long fromUserSeq, @Param("toUserSeq") Long toUserSeq);

  void insertZzim(@Param("fromUserSeq") Long fromUserSeq, @Param("toUserSeq") Long toUserSeq);

  Long countZzim(Long toUserSeq);
}
