package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface LikePostProcessingLogMapper {

  Long getLastProcessedSeq();
  void updateLastProcessedSeq(Long seq);
}
