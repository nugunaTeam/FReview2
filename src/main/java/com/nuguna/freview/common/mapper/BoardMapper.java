package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.NoticePostDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BoardMapper {

  int selectTotalPage(String postCode);
  int selectTotalPageWithSearchWord(@Param("postCode") String postCode, @Param("searchWord") String searchWord);
  List<NoticePostDTO> selectNoticeList(@Param("offset") int offset, @Param("pageSize") int pageSize);
  List<NoticePostDTO> searchNoticeList(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("searchWord") String searchWord);
}
