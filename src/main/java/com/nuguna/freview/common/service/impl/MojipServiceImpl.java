package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.MojipPostDTO;
import com.nuguna.freview.common.mapper.MojipMapper;
import com.nuguna.freview.common.service.MojipService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MojipServiceImpl implements MojipService {

  private final MojipMapper mojipMapper;

  @Autowired
  public MojipServiceImpl(MojipMapper mojipMapper) {
    this.mojipMapper = mojipMapper;
  }

  @Override
  public List<MojipPostDTO> getMojipList(Long previousPostSeq, String searchWord, int pageSize) {
    if (searchWord == null) {
      return mojipMapper.selectMojipList(previousPostSeq, pageSize);
    } else {
      return mojipMapper.searchMojipList(previousPostSeq, pageSize, searchWord);
    }
  }
}
