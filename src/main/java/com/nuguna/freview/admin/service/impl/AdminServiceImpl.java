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
}