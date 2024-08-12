package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.ReviewLogInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;



public interface CustomerReviewMapper {

  Boolean checkAlreadyExistReview(@Param("reviewSeq") Long reviewSeq);

  Boolean checkIsValidReview(@Param("userSeq") Long userSeq, @Param("reviewSeq") Long reviewSeq);

  void registerReview(@Param("reviewSeq") Long reviewSeq, @Param("reviewUrl") String reviewUrl);

  List<ReviewLogInfoDTO> getReviewsInfo(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  List<ReviewLogInfoDTO> getOtherReviewsInfo(@Param("userSeq") Long userSeq,
      @Param("offset") int offset, @Param("pageSize") int pageSize);

  Integer getReviewCount(@Param("userSeq") Long userSeq);

  Integer getOtherReviewCount(@Param("userSeq") Long userSeq);

}
