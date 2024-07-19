package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.page.CustomerBrandInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerPageMapper {

  CustomerBrandInfoResponseDTO getBrandInfo(Long userSeq);

}
