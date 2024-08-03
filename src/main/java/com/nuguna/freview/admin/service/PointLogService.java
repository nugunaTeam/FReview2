package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.mapper.RankPointAccumulationMapper;
import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.admin.mapper.RankPostprocessingLogMapper;
import com.nuguna.freview.admin.vo.PointAccumulationVO;
import com.nuguna.freview.admin.vo.PointLogVO;
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
public class PointLogService {

  private final RankPointLogMapper rankPointLogMapper;
  private final RankPointAccumulationMapper rankPointAccumulationMapper;
  private final RankPostprocessingLogMapper rankPostprocessingLogMapper;

  @Value("${point.log.cycle.fixedRate}")
  private long fixedRate;

  @Autowired
  public PointLogService(RankPointLogMapper rankPointLogMapper,
      RankPointAccumulationMapper rankPointAccumulationMapper,
      RankPostprocessingLogMapper rankPostprocessingLogMapper) {
    this.rankPointLogMapper = rankPointLogMapper;
    this.rankPointAccumulationMapper = rankPointAccumulationMapper;
    this.rankPostprocessingLogMapper = rankPostprocessingLogMapper;
  }

  @Scheduled(fixedRateString = "${point.log.cycle.fixedRate}")
  @Transactional
  public void processPointLog() {
    Long lastProcessedSeq = rankPostprocessingLogMapper.getLastProcessedSeq();
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<PointLogVO> newLogs = rankPointLogMapper.getNewLogs(lastProcessedSeq);

    if (!newLogs.isEmpty()) {
      Map<Long, Long> pointUpdates = newLogs.stream()
          .collect(Collectors.groupingBy(PointLogVO::getUserSeq,
              Collectors.summingLong(log -> calculatePoints(log.getCode()))));

      pointUpdates.forEach((userSeq, points) -> {
        PointAccumulationVO currentAccumulation = rankPointAccumulationMapper.getByUserSeq(userSeq);
        if (currentAccumulation == null) {
          currentAccumulation = new PointAccumulationVO(userSeq, points);
          rankPointAccumulationMapper.insert(currentAccumulation);
        } else {
          currentAccumulation.updateTotalPoint(currentAccumulation.getTotalPoint() + points);
          rankPointAccumulationMapper.update(currentAccumulation);
        }
      });

      Long maxSeq = newLogs.stream().mapToLong(PointLogVO::getSeq).max().getAsLong();
      rankPostprocessingLogMapper.updateLastProcessedSeq(maxSeq);
    }
  }

  private long calculatePoints(String code) {
    switch (code) {
      case "POST":
        return 3;
      case "UNPOST":
        return -3;
      case "ZZIM":
        return 1;
      case "UNZZIM":
        return -1;
      default:
        return 0;
    }
  }
}
