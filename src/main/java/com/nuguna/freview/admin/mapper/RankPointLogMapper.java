package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.PointLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RankPointLogMapper {

  List<PointLogVO> getNewLogs(Long lastProcessedSeq);
  int insertPointLog(@Param("userSeq") Long userSeq, @Param("code") String code);
}
