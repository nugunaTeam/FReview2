package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.response.CustomerInfoDTO;
import com.nuguna.freview.admin.dto.response.StoreInfoDTO;
import com.nuguna.freview.admin.dto.response.page.AdminProfileDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;

public interface AdminService {

    AdminVO getAdminById(Long userSeq);
    List<CustomerInfoDTO> getCustomerList(Long previousUserSeq, String searchWord, Integer pageSize);
    List<StoreInfoDTO> getStoreList(Long previousUserSeq, String searchWord, Integer pageSize);
    boolean isPasswordValid(Long adminSeq, String password);
    boolean deleteUser(Long userSeq);
    void deleteUser(Long adminSeq, String adminVerificationPW, Long deleteUserSeq);
    AdminProfileDTO getAdminProfile(Long userSeq);
    void updatePassword(Long userSeq, String newPassword);
}
