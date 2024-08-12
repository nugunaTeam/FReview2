package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.ZzimLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ZzimLogMapper {
  List<ZzimLogVO> getNewLogs(Long lastProcessedSeq);
  int insertZzimLog(@Param("fromUserSeq") Long fromUserSeq, @Param("toUserSeq") Long toUserSeq, @Param("code") String code);
}
