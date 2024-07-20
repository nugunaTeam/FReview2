package com.nuguna.freview.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

  int insertLikeLog(@Param("postSeq") Long postSeq, @Param("userSeq") Long userSeq, @Param("code") String code);
}
