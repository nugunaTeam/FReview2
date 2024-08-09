package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.admin.mapper.ZzimLogMapper;
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
  private final ZzimLogMapper zzimLogMapper;
  private final RankPointLogMapper rankPointLogMapper;


  @Autowired
  public CommonBrandServiceImpl(CommonBrandMapper commonBrandMapper, ZzimLogMapper zzimLogMapper,
      RankPointLogMapper rankPointLogMapper) {
    this.commonBrandMapper = commonBrandMapper;
    this.zzimLogMapper = zzimLogMapper;
    this.rankPointLogMapper = rankPointLogMapper;
  }

  @Override
  @Transactional
  public ZzimResponseDTO toggleZzim(ZzimRequestDTO zzimRequestDTO) {
    String zzim = "ZZIM";
    String unZzim = "UNZZIM";

    Long fromUserSeq = zzimRequestDTO.getFromUserSeq();
    Long toUserSeq = zzimRequestDTO.getToUserSeq();

    boolean isZzimed = commonBrandMapper.isZzimed(fromUserSeq, toUserSeq);
    if (isZzimed) {
      commonBrandMapper.deleteZzim(fromUserSeq, toUserSeq);
      zzimLogMapper.insertZzimLog(fromUserSeq, toUserSeq, unZzim);
      rankPointLogMapper.insertPointLog(toUserSeq, unZzim);

    } else {
      commonBrandMapper.insertZzim(fromUserSeq, toUserSeq);
      zzimLogMapper.insertZzimLog(fromUserSeq, toUserSeq, zzim);
      rankPointLogMapper.insertPointLog(toUserSeq, zzim);
    }
    Long zzimCount = commonBrandMapper.countZzim(toUserSeq);
    return new ZzimResponseDTO(!isZzimed, zzimCount);
  }
}
