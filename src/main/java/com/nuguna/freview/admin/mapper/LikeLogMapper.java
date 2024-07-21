package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.LikeLogVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface LikeLogMapper {

  int insertLikeLog(@Param("postSeq") Long postSeq, @Param("userSeq") Long userSeq, @Param("code") String code);
  List<LikeLogVO> getNewLogs(Long lastProcessedSeq);
}
