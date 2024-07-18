package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.request.ZzimRequestDTO;
import com.nuguna.freview.common.dto.response.ZzimResponseDTO;

public interface CommonBrandService {

  ZzimResponseDTO toggleZzim(ZzimRequestDTO zzimRequestDTO);
}
