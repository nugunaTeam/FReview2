package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.ExperienceLogDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExperienceMapper {

  List<ExperienceLogDTO> selectExperiencesToNoShow(Long lastProcessedSeq);
}
