package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.dto.response.page.InterestStatsResponseDTO;
import com.nuguna.freview.admin.service.InterestService;
import com.nuguna.freview.common.dto.InterestAccumulationDTO;
import com.nuguna.freview.common.mapper.InterestAccumulationMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InterestServiceImpl implements InterestService {

  private final InterestAccumulationMapper interestAccumulationMapper;

  @Autowired
  public InterestServiceImpl(InterestAccumulationMapper interestAccumulationMapper) {
    this.interestAccumulationMapper = interestAccumulationMapper;
  }

  @Override
  public List<InterestStatsResponseDTO> getInterestStats() {
    List<InterestAccumulationDTO> list = interestAccumulationMapper.findAll();

      Map<String, InterestStatsResponseDTO> statsMap = new HashMap<>();

      for (InterestAccumulationDTO dto : list) {
        String dish = dto.getDish();
        String category = dto.getCategory();
        int totalScore = dto.getTotalScore();

        if (statsMap.containsKey(dish)) {
          InterestStatsResponseDTO existingStats = statsMap.get(dish);
          existingStats.setTotalScore(existingStats.getTotalScore() + totalScore);
        } else {
          statsMap.put(dish, new InterestStatsResponseDTO(dish, category, totalScore));
        }
      }

    return new ArrayList<>(statsMap.values());
  }
}
