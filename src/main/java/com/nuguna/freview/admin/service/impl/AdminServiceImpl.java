package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.mapper.AdminMapper;
import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.admin.vo.AdminVO;
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
}