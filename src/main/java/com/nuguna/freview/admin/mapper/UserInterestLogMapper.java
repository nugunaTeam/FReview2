package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.UserInterestLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInterestLogMapper {

  int insertInterestLog(@Param("userSeq") Long userSeq, @Param("code") String code, @Param("category") String category, @Param("dish") String dish);
  List<UserInterestLogVO> getNewLogs(Long lastProcessedSeq);
}
