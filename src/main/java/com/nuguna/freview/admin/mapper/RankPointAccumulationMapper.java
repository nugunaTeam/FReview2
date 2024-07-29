package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.PointAccumulationVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankPointAccumulationMapper {

  PointAccumulationVO getByUserSeq(Long userSeq);
  void insert(PointAccumulationVO pointAccumulation);
  void update(PointAccumulationVO pointAccumulation);
}
