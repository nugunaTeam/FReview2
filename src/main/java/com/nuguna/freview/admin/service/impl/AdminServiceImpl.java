package com.nuguna.freview.admin.service.impl;

import static com.nuguna.freview.global.util.ShaUtil.sha256Encoding;

import com.nuguna.freview.admin.dto.response.CustomerInfoDTO;
import com.nuguna.freview.admin.dto.response.StoreInfoDTO;
import com.nuguna.freview.admin.dto.response.page.AdminProfileDTO;
import com.nuguna.freview.admin.mapper.AdminMapper;
import com.nuguna.freview.admin.service.AdminService;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  public List<CustomerInfoDTO> getCustomerList(Long previousUserSeq, String searchWord, Integer pageSize) {
    if (searchWord == null || searchWord.isEmpty()) {
      return adminMapper.selectCustomerList(previousUserSeq, pageSize);
    } else {
      return adminMapper.searchCustomer(previousUserSeq, searchWord, pageSize);
    }
  }

  @Override
  public List<StoreInfoDTO> getStoreList(Long previousUserSeq, String searchWord,
      Integer pageSize) {
    if (searchWord == null) {
      return adminMapper.selectStoreList(previousUserSeq, pageSize);
    } else {
      return adminMapper.searchStore(previousUserSeq, searchWord, pageSize);
    }
  }

  @Override
  public boolean isPasswordValid(Long adminSeq, String password) {
    String oldPasswordHash = sha256Encoding(password);
    return adminMapper.selectMatchingAdmin(adminSeq, oldPasswordHash) > 0;
  }

  @Override
  @Transactional
  public boolean deleteUser(Long userSeq) {
    return adminMapper.deleteUser(userSeq) > 0;
  }

  @Override
  @Transactional
  public void deleteUser(Long adminSeq, String adminVerificationPW, Long deleteUserSeq) {
    if (!isPasswordValid(adminSeq, adminVerificationPW)) {
      throw new IllegalArgumentException("[ERROR] 입력한 비밀번호는 올바르지 않습니다.");
    }
    if (!deleteUser(deleteUserSeq)) {
      throw new IllegalStateException("[ERROR] 유저 삭제에 실패하였습니다.");
    }
  }

  @Override
  @Transactional
  public AdminProfileDTO getAdminProfile(Long userSeq) {
    return adminMapper.selectAdminProfile(userSeq);
  }

  @Override
  @Transactional
  public void updatePassword(Long userSeq, String newPassword) {
    String newPasswordHash = sha256Encoding(newPassword);
    adminMapper.updatePassword(userSeq, newPasswordHash);
  }

  @Override
  @Transactional
  public boolean updateSubEmail(Long userSeq, String newEmail) {
    return (adminMapper.updateSubEmail(userSeq, newEmail) > 0);
  }
}