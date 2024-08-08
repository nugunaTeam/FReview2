package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.response.MainPageCustomerMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageMojipMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageRecentGongjiMapperDTO;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainPageMapper {

  List<MainPageMojipMapperDTO> selectHotMojipList();

  List<MainPageCustomerMapperDTO> selectHotCustomerList();

  List<MainPageRecentGongjiMapperDTO> selectRecentGongjiList();
}
