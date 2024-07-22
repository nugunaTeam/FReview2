package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.PointLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankPointLogMapper {

  List<PointLogVO> getNewLogs(Long lastProcessedSeq);
}
