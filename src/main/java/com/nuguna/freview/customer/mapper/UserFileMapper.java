package com.nuguna.freview.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserFileMapper {

  String getFilename(@Param("userSeq") Long userSeq);

}
