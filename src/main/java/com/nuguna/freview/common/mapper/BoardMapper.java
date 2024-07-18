package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.NoticeListDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardMapper {

  int selectTotalPage(String postCode);
  List<NoticeListDTO> selectNoticeList(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
