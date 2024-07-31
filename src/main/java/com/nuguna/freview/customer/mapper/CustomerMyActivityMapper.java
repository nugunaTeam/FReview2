package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.MyLikePostInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMyActivityMapper {

  Integer getLikesCount(@Param("userSeq") Long userSeq);

  List<MyLikePostInfoDTO> getMyLikedPosts(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);
}