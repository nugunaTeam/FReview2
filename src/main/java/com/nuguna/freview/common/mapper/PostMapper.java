package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper {

  NoticeDetailResponseDTO selectNotice(Long postSeq);
  int checkPostLiked(@Param("userSeq") Long userSeq, @Param("postSeq") Long postSeq);
}
