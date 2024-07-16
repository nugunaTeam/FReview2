package com.nuguna.freview.customer.mapper;

import com.nuguna.freview.customer.dto.response.page.CustomerMyBrandPageInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerPageMapper {

  CustomerMyBrandPageInfoResponseDTO getCustomerBrandPageInfo(Long userSeq);

}
