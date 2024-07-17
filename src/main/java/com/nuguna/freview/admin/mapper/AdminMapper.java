package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

  public AdminVO selectAdmin(Long userSeq);
  public List<CustomerListDTO> selectCustomerList(CustomerListRequestDTO dto);
}
