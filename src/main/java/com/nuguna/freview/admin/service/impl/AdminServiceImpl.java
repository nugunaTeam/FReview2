package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.mapper.AdminMapper;
import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  private final AdminMapper adminMapper;

  @Autowired
  public AdminServiceImpl(AdminMapper adminMapper) {
    this.adminMapper = adminMapper;
  }

  @Override
  public AdminVO getAdminById(Long userSeq) {
    return adminMapper.selectAdmin(userSeq);
  }

  @Override
  public List<CustomerListDTO> getCustomerList(CustomerListRequestDTO dto) {
    return adminMapper.selectCustomerList(dto);
  }

  @Override
  public List<CustomerListDTO> getSearchedCustomerList(Long previousUserSeq, String searchWord, Integer limit) {
    return adminMapper.searchCustomer(previousUserSeq, searchWord, limit);
  }

  @Override
  public boolean isPasswordValid(Long adminSeq, String password) {
    return adminMapper.selectMatchingAdmin(adminSeq, password) > 0;
  }

  @Override
  public boolean deleteUser(Long userSeq) {
    return adminMapper.deleteUser(userSeq) > 0;
  }

  @Override
  public void deleteCustomer(Long adminSeq, String adminVerificationPW, Long deleteUserSeq) {
    if (!isPasswordValid(adminSeq, adminVerificationPW)) {
      throw new IllegalArgumentException("[ERROR] 입력한 비밀번호는 올바르지 않습니다.");
    }
    if (!deleteUser(deleteUserSeq)) {
      throw new IllegalStateException("[ERROR] 유저 삭제에 실패하였습니다.");
    }
  }
}