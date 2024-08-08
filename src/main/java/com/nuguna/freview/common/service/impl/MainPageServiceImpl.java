package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.common.dto.response.MainPageCustomerMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageMojipMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageRecentGongjiMapperDTO;
import com.nuguna.freview.common.mapper.MainPageMapper;
import com.nuguna.freview.common.service.MainPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainPageServiceImpl implements MainPageService {

  private final MainPageMapper mainPageMapper;

  @Autowired
  public MainPageServiceImpl(MainPageMapper mainPageMapper) {
    this.mainPageMapper = mainPageMapper;
  }

  @Override
  public List<MainPageMojipMapperDTO> getHotMojipList() {
    return mainPageMapper.selectHotMojipList();
  }

  @Override
  public List<MainPageCustomerMapperDTO> getHotCustomerList() {
    return mainPageMapper.selectHotCustomerList();
  }

  @Override
  public List<MainPageRecentGongjiMapperDTO> getRecentGongjiList() {
    return mainPageMapper.selectRecentGongjiList();
  }
}
