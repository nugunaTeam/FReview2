package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.MojipPostDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MojipMapper {

  List<MojipPostDTO> selectMojipList(@Param("previousPostSeq") Long previousPostSeq, @Param("limit") int limit);
  List<MojipPostDTO> searchMojipList(@Param("previousPostSeq") Long previousPostSeq, @Param("limit") int limit, @Param("searchWord") String keyword);
  MojipPostDTO selectMojipDetail(@Param("postSeq") Long postSeq);
}
