package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.LikeAccumulationVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LikeAccumulationMapper {

  LikeAccumulationVO findByPostSeq(Long postSeq);
  void insert(LikeAccumulationVO accumulation);
  void update(LikeAccumulationVO accumulation);
}
