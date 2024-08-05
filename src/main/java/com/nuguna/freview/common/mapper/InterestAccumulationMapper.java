package com.nuguna.freview.common.mapper;

import com.nuguna.freview.common.dto.InterestAccumulationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterestAccumulationMapper {
  List<InterestAccumulationDTO> getByUserSeq(Long userSeq);
  List<InterestAccumulationDTO> findAll();
}
