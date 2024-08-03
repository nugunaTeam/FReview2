package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.DoneExperienceDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoneExperienceAccumulationMapper {

  DoneExperienceDTO findByDate(LocalDate date);
  void insert(DoneExperienceDTO record);
  void update(DoneExperienceDTO record);
  List<DoneExperienceDTO> findAll();
}
