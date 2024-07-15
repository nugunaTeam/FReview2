package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.request.CustomerSignupRequestDTO;

public interface UserService {

  void signup(CustomerSignupRequestDTO customerSignupRequestDTO);
}
