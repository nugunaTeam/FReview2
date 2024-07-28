package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInterestPostprocessingLogMapper {

  Long getLastProcessedSeq();
  void updateLastProcessedSeq(@Param("lastProcessedSeq") Long lastProcessedSeq);
}
