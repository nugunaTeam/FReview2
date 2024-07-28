package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.ZzimAccumulationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZzimAccumulationMapper {
  ZzimAccumulationVO getByUserSeq(Long userSeq);
  void insert(ZzimAccumulationVO zzimAccumulation);
  void update(ZzimAccumulationVO zzimAccumulation);
}
