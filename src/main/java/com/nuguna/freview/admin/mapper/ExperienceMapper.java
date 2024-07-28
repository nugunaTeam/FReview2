package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.dto.DoneExperienceLogDTO;
import com.nuguna.freview.admin.dto.NoShowExperienceLogDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExperienceMapper {

  List<NoShowExperienceLogDTO> selectNoShowExperiences(@Param("lastProcessedSeq") Long lastProcessedSeq, @Param("status") String status);
  List<DoneExperienceLogDTO> selectDoneExperiences(@Param("lastProcessedSeq") Long lastProcessedSeq, @Param("status") String status);
}
