package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.mapper.MojipMapper;
import com.nuguna.freview.common.service.MojipService;
import java.util.Date;
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
  public List<MojipPostDetailDTO> getMojipList(Long previousPostSeq, String searchWord, int pageSize) {
    if (searchWord == null) {
      return mojipMapper.selectMojipList(previousPostSeq, pageSize);
    } else {
      return mojipMapper.searchMojipList(previousPostSeq, pageSize, searchWord);
    }
  }

  @Override
  public MojipPostDetailDTO getMojipDetail(Long postSeq) {
    return mojipMapper.selectMojipDetail(postSeq);
  }

  @Override
  public boolean createMojip(Long userSeq, String title, Date applyStartDate,
      Date applyEndDate, Date experienceDate, String content) {
    int result = mojipMapper.insertMojip(userSeq, title, applyStartDate, applyEndDate, experienceDate, content);
    return result == 1;
  }

  @Override
  public boolean updateMojip(Long postSeq, String title, String content) {
   int result = mojipMapper.updateMojip(postSeq, title, content);
   return result == 1;
  }
}
