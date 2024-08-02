package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.request.ZzimRequestDTO;
import com.nuguna.freview.common.dto.response.ZzimResponseDTO;
import com.nuguna.freview.common.mapper.CommonBrandMapper;
import com.nuguna.freview.common.service.CommonBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CommonBrandServiceImpl implements CommonBrandService {

  private final CommonBrandMapper commonBrandMapper;

  @Autowired
  public CommonBrandServiceImpl(CommonBrandMapper commonBrandMapper) {
    this.commonBrandMapper = commonBrandMapper;
  }

  @Override
  @Transactional
  public ZzimResponseDTO toggleZzim(ZzimRequestDTO zzimRequestDTO) {
    Long fromUserSeq = zzimRequestDTO.getFromUserSeq();
    Long toUserSeq = zzimRequestDTO.getToUserSeq();

    boolean isZzimed = commonBrandMapper.isZzimed(fromUserSeq, toUserSeq);
    if (isZzimed) {
      commonBrandMapper.deleteZzim(fromUserSeq, toUserSeq);
    } else {
      commonBrandMapper.insertZzim(fromUserSeq, toUserSeq);
    }
    Long zzimCount = commonBrandMapper.countZzim(toUserSeq);
    return new ZzimResponseDTO(!isZzimed, zzimCount);
  }
}
