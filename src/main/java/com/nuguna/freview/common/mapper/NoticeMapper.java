package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.NoticePostDTO;
import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import java.sql.Timestamp;
import java.util.List;
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
  List<NoticePostDTO> selectNoticeList(@Param("offset") int offset, @Param("pageSize") int pageSize);
  List<NoticePostDTO> searchNoticeList(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("searchWord") String searchWord);
}
