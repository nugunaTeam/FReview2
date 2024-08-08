package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.mapper.UserInterestAccumulationMapper;
import com.nuguna.freview.admin.mapper.UserInterestLogMapper;
import com.nuguna.freview.admin.mapper.UserInterestPostprocessingLogMapper;
import com.nuguna.freview.admin.vo.UserInterestLogVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserInterestLogService {

  private final UserInterestLogMapper userInterestLogMapper;
  private final UserInterestAccumulationMapper userInterestAccumulationMapper;
  private final UserInterestPostprocessingLogMapper userInterestPostprocessingLogMapper;

  @Value("${user.interest.log.cycle.fixedRate}")
  private long interestLogCycle;

  @Autowired
  public UserInterestLogService(UserInterestLogMapper userInterestLogMapper,
      UserInterestAccumulationMapper userInterestAccumulationMapper,
      UserInterestPostprocessingLogMapper userInterestPostprocessingLogMapper) {
    this.userInterestLogMapper = userInterestLogMapper;
    this.userInterestAccumulationMapper = userInterestAccumulationMapper;
    this.userInterestPostprocessingLogMapper = userInterestPostprocessingLogMapper;
  }

  @Scheduled(fixedRateString = "${user.interest.log.cycle.fixedRate}")
  @Transactional
  public void processUserInterestLogs() {
    Long lastProcessedSeq = userInterestPostprocessingLogMapper.getLastProcessedSeq();
    if (lastProcessedSeq == null) {
      lastProcessedSeq = 0L;
    }

    List<UserInterestLogVO> logs = userInterestLogMapper.getNewLogs(lastProcessedSeq);

    if (!logs.isEmpty()) {
      Map<String, Integer> scoreMap = new HashMap<>();

      for (UserInterestLogVO log : logs) {
        String key = log.getUserSeq() + "|" + log.getCategory() + "|" + log.getDish();
        scoreMap.put(key, scoreMap.getOrDefault(key, 0) + 1);
        lastProcessedSeq = log.getSeq();
      }

      Set<String> keys = scoreMap.keySet();
      List<String> existingKeys = userInterestAccumulationMapper.getExistingKeys(keys);

      scoreMap.forEach((key, score) -> {
        String[] parts = key.split("\\|");
        Long userSeq = Long.parseLong(parts[0]);
        String category = parts[1];
        String dish = parts[2];

        if (existingKeys.contains(key)) {
          userInterestAccumulationMapper.updateScore(userSeq, category, dish, score);
        } else {
          userInterestAccumulationMapper.insertScore(userSeq, category, dish, score);
        }
      });

      if (lastProcessedSeq != null) {
        userInterestPostprocessingLogMapper.updateLastProcessedSeq(lastProcessedSeq);
      }
    }
  }
}
