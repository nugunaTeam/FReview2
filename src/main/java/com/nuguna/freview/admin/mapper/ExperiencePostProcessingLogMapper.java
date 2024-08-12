package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExperiencePostProcessingLogMapper {

  void updateLastProcessedSeq(@Param("purpose") String purpose, @Param("seq") Long seq);
  Long getLastProcessedSeq(String purpose);
}
