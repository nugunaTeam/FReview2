package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.mapper.LikeAccumulationMapper;
import com.nuguna.freview.admin.mapper.LikeLogMapper;
import com.nuguna.freview.admin.mapper.LikePostProcessingLogMapper;
import com.nuguna.freview.admin.vo.LikeAccumulationVO;
import com.nuguna.freview.admin.vo.LikeLogVO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LikeLogService {

  private final LikeLogMapper likeLogMapper;
  private final LikeAccumulationMapper likeAccumulationMapper;
  private final LikePostProcessingLogMapper likePostProcessingLogMapper;

  @Value("${like.log.cycle.fixedRate}")
  private long likeLogCycle;

  @Autowired
  public LikeLogService(LikeLogMapper likeMapper, LikeAccumulationMapper likeAccumulationMapper,
      LikePostProcessingLogMapper likePostProcessingLogMapper) {
    this.likeLogMapper = likeMapper;
    this.likeAccumulationMapper = likeAccumulationMapper;
    this.likePostProcessingLogMapper = likePostProcessingLogMapper;
  }

  @Scheduled(fixedRateString = "${like.log.cycle.fixedRate}")
  @Transactional
  public void processLikeLogs() {
    Long lastProcessedSeq = likePostProcessingLogMapper.getLastProcessedSeq();
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<LikeLogVO> newLogs = likeLogMapper.getNewLogs(lastProcessedSeq);

    if (!newLogs.isEmpty()) {
      Map<Long, Long> likeCounts = newLogs.stream()
          .collect(Collectors.groupingBy(LikeLogVO::getPostSeq,
              Collectors.summingLong(log -> log.getCode().equals("LIKE") ? 1L : -1L)));

      likeCounts.forEach((postSeq, count) -> {
        LikeAccumulationVO currentAccumulation = likeAccumulationMapper.getByPostSeq(postSeq);
        if (currentAccumulation == null) {
          currentAccumulation = new LikeAccumulationVO(postSeq, count);
          likeAccumulationMapper.insert(currentAccumulation);
        } else {
          currentAccumulation.updateTotalLike(currentAccumulation.getTotalLike() + count);
          likeAccumulationMapper.update(currentAccumulation);
        }
      });

      Long maxSeq = newLogs.stream().mapToLong(LikeLogVO::getSeq).max().getAsLong();
      likePostProcessingLogMapper.updateLastProcessedSeq(maxSeq);
    }
  }
}
