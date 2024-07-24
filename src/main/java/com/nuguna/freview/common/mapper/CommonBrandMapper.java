package com.nuguna.freview.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommonBrandMapper {

  Boolean isZzimed(@Param("userSeq") Long userSeq, @Param("toUserSeq") Long toUserSeq);

  void deleteZzim(@Param("userSeq") Long userSeq, @Param("toUserSeq") Long toUserSeq);

  void insertZzim(@Param("userSeq") Long userSeq, @Param("toUserSeq") Long toUserSeq);

  Long countZzim(Long toUserSeq);
}
