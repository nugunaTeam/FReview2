package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.CustomerRecommendationResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecommendationMapper {

  List<CustomerRecommendationResponseDTO> selectCustomer(@Param("previousUserSeq") Long previousUserSeq, @Param("limit") int limit);
  List<CustomerRecommendationResponseDTO> filterUsers(
      @Param("previousUserSeq") Long previousSeq,
      @Param("limit") int limit,
      @Param("foodTypes") List<String> foodTypes,
      @Param("tags") List<String> tags,
      @Param("code") String code);
}
