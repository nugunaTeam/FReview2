package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.MainPageCustomerMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageMojipMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageRecentGongjiMapperDTO;
import java.util.List;

public interface MainPageService {

  List<MainPageMojipMapperDTO> getHotMojipList();

  List<MainPageCustomerMapperDTO> getHotCustomerList();

  List<MainPageRecentGongjiMapperDTO> getRecentGongjiList();
}
