package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import java.sql.Timestamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NoticeMapper {

  NoticeDetailResponseDTO selectNotice(Long postSeq);
  int updateNotice(@Param("postSeq") Long postSeq,
      @Param("title") String title,
      @Param("content") String content,
      @Param("updatedAt") Timestamp updatedAt);
  int insertNotice(@Param("userSeq") Long userSeq, @Param("title") String title, @Param("content") String content, @Param("now") Timestamp now);


}