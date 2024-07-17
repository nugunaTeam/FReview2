package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

  AdminVO selectAdmin(Long userSeq);
  List<CustomerListDTO> selectCustomerList(CustomerListRequestDTO dto);
  List<CustomerListDTO> searchCustomer(@Param("previousUserSeq") Long previousUserSeq, @Param("searchWord") String searchWord, @Param("limit") Integer limit);
  int selectMatchingAdmin(@Param("adminSeq") Long userSeq, @Param("password")String password);
  int deleteUser(Long userSeq);
}
