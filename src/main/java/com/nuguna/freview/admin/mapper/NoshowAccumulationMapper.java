package com.nuguna.freview.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoshowAccumulationMapper {

  int insertNoshowAccumulation(Long userSeq);
  int updateNoshowAccumulation(Long userSeq);
}
