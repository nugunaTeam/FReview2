package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.CustomerRecommendationResponseDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecommendationMapper {

  List<CustomerRecommendationResponseDTO> selectCustomer(@Param("previousUserSeq") Long previousUserSeq, @Param("limit") int limit);
}
