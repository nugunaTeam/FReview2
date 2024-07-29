package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.DoneExperienceDTO;
import com.nuguna.freview.admin.dto.DoneExperienceLogDTO;
import com.nuguna.freview.admin.dto.NoShowExperienceLogDTO;
import com.nuguna.freview.admin.mapper.DoneExperienceAccumulationMapper;
import com.nuguna.freview.admin.mapper.ExperienceLogMapper;
import com.nuguna.freview.admin.mapper.ExperiencePostProcessingLogMapper;
import com.nuguna.freview.admin.mapper.NoshowAccumulationMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExperienceLogService {

  private final ExperienceLogMapper experienceMapper;
  private final NoshowAccumulationMapper noshowAccumulationMapper;
  private final ExperiencePostProcessingLogMapper experiencePostProcessingLogMapper;
  private final DoneExperienceAccumulationMapper doneExperienceAccumulationMapper;

  @Autowired
  public ExperienceLogService(ExperienceLogMapper experienceMapper,
      NoshowAccumulationMapper noshowAccumulationMapper,
      ExperiencePostProcessingLogMapper experiencePostProcessingLogMapper,
      DoneExperienceAccumulationMapper doneExperienceAccumulationMapper) {
    this.experienceMapper = experienceMapper;
    this.noshowAccumulationMapper = noshowAccumulationMapper;
    this.experiencePostProcessingLogMapper = experiencePostProcessingLogMapper;
    this.doneExperienceAccumulationMapper = doneExperienceAccumulationMapper;
  }

  @Scheduled(cron = "0 0 12,0 * * *")
  @Transactional
  public void processNoShowExperiences() {
    String purpose = "NOSHOW_ACCUMULATION";
    String status = "NOSHOW";
    Long lastProcessedSeq = experiencePostProcessingLogMapper.getLastProcessedSeq(purpose);
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<NoShowExperienceLogDTO> experiences = experienceMapper.selectNoShowExperiences(
        lastProcessedSeq, status);

    if (!experiences.isEmpty()) {
      experiences.forEach(experience -> {
        Long userSeqForAccumulation =
            (experience.getFromPostSeq() == null) ? experience.getToUserSeq()
                : experience.getFromUserSeq();
        int rowUpdated = noshowAccumulationMapper.updateNoshowAccumulation(userSeqForAccumulation);
        if (rowUpdated == 0) {
          noshowAccumulationMapper.insertNoshowAccumulation(userSeqForAccumulation);
        }
      });

      Long maxSeq = experiences.stream()
          .mapToLong(NoShowExperienceLogDTO::getSeq)
          .max()
          .getAsLong();
      experiencePostProcessingLogMapper.updateLastProcessedSeq(purpose, maxSeq);
    }
  }

  @Scheduled(cron = "0 0 12,0 * * *")
  @Transactional
  public void processDoneExperiences() {
    String purpose = "DONE_EXPERIENCE_ACCUMULATION";
    String status = "DONE";
    Long lastProcessedSeq = experiencePostProcessingLogMapper.getLastProcessedSeq(purpose);
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<DoneExperienceLogDTO> experiences = experienceMapper.selectDoneExperiences(
        lastProcessedSeq, status);
    if (!experiences.isEmpty()) {
      Map<LocalDate, Long> dailyCounts = experiences.stream()
          .collect(Collectors.groupingBy(
              experience -> experience.getVisitDate(),
              Collectors.counting()
          ));

      dailyCounts.forEach((date, count) -> {
        DoneExperienceDTO existingRecord = doneExperienceAccumulationMapper.findByDate(date);
        if (existingRecord == null) {
          doneExperienceAccumulationMapper.insert(new DoneExperienceDTO(date, count));
        } else {
          existingRecord.setTotalDone(existingRecord.getTotalDone() + count);
          doneExperienceAccumulationMapper.update(existingRecord);
        }
      });

      Long maxSeq = experiences.stream()
          .mapToLong(DoneExperienceLogDTO::getSeq)
          .max()
          .getAsLong();
      experiencePostProcessingLogMapper.updateLastProcessedSeq(purpose, maxSeq);
    }
  }
}
