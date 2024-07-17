package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.request.CustomerListRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerListDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;

public interface AdminService {

    AdminVO getAdminById(Long userSeq);
    List<CustomerListDTO> getCustomerList(CustomerListRequestDTO dto);
    List<CustomerListDTO> getSearchedCustomerList(Long previousUserSeq, String searchWord, Integer limit);
    boolean isPasswordValid(Long adminSeq, String password);
    boolean deleteUser(Long userSeq);
    void deleteCustomer(Long adminSeq, String adminVerificationPW, Long deleteUserSeq);
}
