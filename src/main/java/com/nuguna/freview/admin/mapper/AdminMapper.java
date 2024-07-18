package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.dto.response.StoreListDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

  AdminVO selectAdmin(Long userSeq);
  List<CustomerListDTO> selectCustomerList(@Param("previousUserSeq") Long previousUserSeq, @Param("limit") Integer limit);
  List<CustomerListDTO> searchCustomer(@Param("previousUserSeq") Long previousUserSeq, @Param("searchWord") String searchWord, @Param("limit") Integer limit);
  List<StoreListDTO> selectStoreList(@Param("previousUserSeq") Long previousUserSeq, @Param("limit") Integer limit);
  List<StoreListDTO> searchStore(@Param("previousUserSeq") Long previousUserSeq, @Param("searchWord") String searchWord, @Param("limit") Integer limit);
  int selectMatchingAdmin(@Param("adminSeq") Long userSeq, @Param("password")String password);
  int deleteUser(Long userSeq);
}
