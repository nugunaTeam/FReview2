package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.HiddenReviewDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {

  List<HiddenReviewDTO> getHiddenReviews(@Param("offset") int offset, @Param("pageSize") int pageSize);
  int selectTotalPage();
  int deleteReview(Long seq);
}
