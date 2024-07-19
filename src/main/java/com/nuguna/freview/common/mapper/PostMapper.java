package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import java.sql.Timestamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {

  NoticeDetailResponseDTO selectNotice(Long postSeq);
  int checkPostLiked(@Param("userSeq") Long userSeq, @Param("postSeq") Long postSeq);
  void insertPostViewCount(@Param("postSeq") Long postSeq);
  int updateNotice(@Param("postSeq") Long postSeq,
      @Param("title") String title,
      @Param("content") String content,
      @Param("updatedAt") Timestamp updatedAt);
}