package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.page.CustomerBrandInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerPageMapper {

  String getNickname(@Param("customerSeq") Long customerSeq);

  CustomerBrandInfoResponseDTO getBrandInfo(@Param("customerSeq") Long customerSeq);

}
