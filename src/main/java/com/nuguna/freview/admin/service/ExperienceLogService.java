package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.ExperienceLogDTO;
import com.nuguna.freview.admin.mapper.ExperienceMapper;
import com.nuguna.freview.admin.mapper.ExperiencePostProcessingLogMapper;
import com.nuguna.freview.admin.mapper.NoshowAccumulationMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExperienceLogService {

  private final ExperienceMapper experienceMapper;
  private final NoshowAccumulationMapper noshowAccumulationMapper;
  private final ExperiencePostProcessingLogMapper experiencePostProcessingLogMapper;

  @Autowired
  public ExperienceLogService(ExperienceMapper experienceMapper, NoshowAccumulationMapper noshowAccumulationMapper,
      ExperiencePostProcessingLogMapper experiencePostProcessingLogMapper) {
    this.experienceMapper = experienceMapper;
    this.noshowAccumulationMapper = noshowAccumulationMapper;
    this.experiencePostProcessingLogMapper = experiencePostProcessingLogMapper;
  }

  @Scheduled(cron = "0 0 12,0 * * *")
  @Transactional
  public void processNoShowExperiences() {

    Long lastProcessedSeq = experiencePostProcessingLogMapper.getLastProcessedSeq();
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<ExperienceLogDTO> experiences = experienceMapper.selectExperiencesToNoShow(lastProcessedSeq);

    if (!experiences.isEmpty()) {
      experiences.forEach(experience -> {
        Long userSeqForAccumulation = (experience.getFromPostSeq() == null) ? experience.getToUserSeq() : experience.getFromUserSeq();
        int rowUpdated = noshowAccumulationMapper.updateNoshowAccumulation(userSeqForAccumulation);
        if (rowUpdated == 0) {
          noshowAccumulationMapper.insertNoshowAccumulation(userSeqForAccumulation);
        }
      });

      Long maxSeq = experiences.stream().mapToLong(ExperienceLogDTO::getSeq).max().getAsLong();
      experiencePostProcessingLogMapper.updateLastProcessedSeq(maxSeq);
    }
  }
}
