package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExperiencePostProcessingLogMapper {

  void updateLastProcessedSeq(Long seq);
  Long getLastProcessedSeq();
}
