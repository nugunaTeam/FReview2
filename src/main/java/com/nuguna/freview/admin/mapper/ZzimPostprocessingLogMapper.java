package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZzimPostprocessingLogMapper {
  Long getLastProcessedSeq();
  void updateLastProcessedSeq(Long seq);
}
