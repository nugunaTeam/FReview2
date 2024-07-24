package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.mapper.ZzimAccumulationMapper;
import com.nuguna.freview.admin.mapper.ZzimLogMapper;
import com.nuguna.freview.admin.mapper.ZzimPostprocessingLogMapper;
import com.nuguna.freview.admin.vo.ZzimAccumulationVO;
import com.nuguna.freview.admin.vo.ZzimLogVO;
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
public class ZzimLogService {

  private final ZzimLogMapper zzimLogMapper;
  private final ZzimAccumulationMapper zzimAccumulationMapper;
  private final ZzimPostprocessingLogMapper zzimPostprocessingLogMapper;

  @Autowired
  public ZzimLogService(ZzimLogMapper zzimLogMapper, ZzimAccumulationMapper zzimAccumulationMapper,
      ZzimPostprocessingLogMapper zzimPostprocessingLogMapper) {
    this.zzimLogMapper = zzimLogMapper;
    this.zzimAccumulationMapper = zzimAccumulationMapper;
    this.zzimPostprocessingLogMapper = zzimPostprocessingLogMapper;
  }

  @Scheduled(fixedRate = 1000)
  @Transactional
  public void zzimLogsProcess() {
    Long lastProcessedSeq = zzimPostprocessingLogMapper.getLastProcessedSeq();
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<ZzimLogVO> newLogs = zzimLogMapper.getNewLogs(lastProcessedSeq);

    if (!newLogs.isEmpty()) {
      Map<Long, Long> zzimCounts = newLogs.stream()
          .collect(Collectors.groupingBy(ZzimLogVO::getToUserSeq,
              Collectors.summingLong(log -> log.getCode().equals("ZZIM") ? 1L : -1L)));

      zzimCounts.forEach((toUserSeq, count) -> {
        ZzimAccumulationVO currentAccumulation = zzimAccumulationMapper.getByUserSeq(toUserSeq);
        if (currentAccumulation == null) {
          currentAccumulation = new ZzimAccumulationVO(toUserSeq, count);
          zzimAccumulationMapper.insert(currentAccumulation);
        } else {
          currentAccumulation.updateTotalZzim(currentAccumulation.getTotalZzim() + count);
          zzimAccumulationMapper.update(currentAccumulation);
        }
      });

      Long maxSeq = newLogs.stream().mapToLong(ZzimLogVO::getSeq).max().getAsLong();
      zzimPostprocessingLogMapper.updateLastProcessedSeq(maxSeq);
    }
  }
}