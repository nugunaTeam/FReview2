package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankPostprocessingLogMapper {

  Long getLastProcessedSeq();
  void updateLastProcessedSeq(Long seq);
}
