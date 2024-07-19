package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MojipMapper {

  List<MojipPostDetailDTO> selectMojipList(@Param("previousPostSeq") Long previousPostSeq, @Param("limit") int limit);
  List<MojipPostDetailDTO> searchMojipList(@Param("previousPostSeq") Long previousPostSeq, @Param("limit") int limit, @Param("searchWord") String keyword);
  MojipPostDetailDTO selectMojipDetail(@Param("postSeq") Long postSeq);
  int insertMojip(@Param("userSeq") Long userSeq, @Param("title") String title,
      @Param("applyStartDate") Date applyStartDate, @Param("applyEndDate") Date applyEndDate,
      @Param("experienceDate") Date experienceDate, @Param("content") String content);
}
