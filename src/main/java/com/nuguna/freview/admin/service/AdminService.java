package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.request.CustomerManageRequestDTO;
import com.nuguna.freview.admin.dto.response.CustomerManageResponseDTO;
import com.nuguna.freview.admin.vo.AdminVO;
import java.util.List;

public interface AdminService {

    public AdminVO getAdminById(Long userSeq);
    public List<CustomerManageResponseDTO> getCustomerList(CustomerManageRequestDTO dto);

}
