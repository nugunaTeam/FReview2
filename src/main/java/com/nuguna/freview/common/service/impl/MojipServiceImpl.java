package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.admin.mapper.UserInterestLogMapper;
import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.mapper.MojipMapper;
import com.nuguna.freview.common.service.MojipService;
import com.nuguna.freview.common.vo.user.foodType.FoodDish;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MojipServiceImpl implements MojipService {

  private final MojipMapper mojipMapper;
  private final UserInterestLogMapper userInterestLogMapper;

  @Autowired
  public MojipServiceImpl(MojipMapper mojipMapper, UserInterestLogMapper userInterestLogMapper) {
    this.mojipMapper = mojipMapper;
    this.userInterestLogMapper = userInterestLogMapper;
  }

  @Override
  @Transactional
  public List<MojipPostDetailDTO> getMojipList(Long requesterSeq, Long previousPostSeq, String searchWord, int pageSize) {
    if (searchWord != null && !searchWord.isEmpty()) {
      insertSearchLog(requesterSeq, searchWord);
      return mojipMapper.searchMojipList(previousPostSeq, pageSize, searchWord);
    } else {
      return mojipMapper.selectMojipList(previousPostSeq, pageSize);
    }
  }

  @Override
  public MojipPostDetailDTO getMojipDetail(Long postSeq) {
    return mojipMapper.selectMojipDetail(postSeq);
  }

  @Override
  public boolean createMojip(Long userSeq, String title, Date applyStartDate,
      Date applyEndDate, Date experienceDate, String content) {
    int result = mojipMapper.insertMojip(userSeq, title, applyStartDate, applyEndDate, experienceDate, content);
    return result == 1;
  }

  @Override
  public boolean updateMojip(Long postSeq, String title, String content) {
   int result = mojipMapper.updateMojip(postSeq, title, content);
   return result == 1;
  }

  @Override
  public boolean applyMojip(Long fromUserSeq, Long toUserSeq, Long fromPostSeq) {
    int result = mojipMapper.applyMojip(fromUserSeq, toUserSeq, fromPostSeq);
    return result == 1;
  }

  private void insertSearchLog(Long requesterSeq, String searchWord) {
    Arrays.stream(FoodDish.values())
        .filter(food -> searchWord.contains(food.getCode()))
        .forEach(food -> userInterestLogMapper.insertInterestLog(requesterSeq, "SEARCH", food.getFoodType().getCode(), food.getCode()));
  }
}
