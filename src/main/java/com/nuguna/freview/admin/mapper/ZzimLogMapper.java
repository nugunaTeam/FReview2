package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.ZzimLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZzimLogMapper {
  List<ZzimLogVO> getNewLogs(Long lastProcessedSeq);
}
