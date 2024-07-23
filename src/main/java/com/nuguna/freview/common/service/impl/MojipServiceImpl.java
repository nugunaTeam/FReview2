package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.admin.mapper.UserFoodTypeMapper;
import com.nuguna.freview.admin.mapper.UserInterestLogMapper;
import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.mapper.MojipMapper;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.MojipService;
import com.nuguna.freview.common.vo.user.foodType.FoodDish;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MojipServiceImpl implements MojipService {

  private final MojipMapper mojipMapper;
  private final PostMapper postMapper;
  private final RankPointLogMapper rankPointLogMapper;
  private final UserInterestLogMapper userInterestLogMapper;
  private final UserFoodTypeMapper userFoodTypeMapper;

  @Autowired
  public MojipServiceImpl(MojipMapper mojipMapper, UserInterestLogMapper userInterestLogMapper,
      UserFoodTypeMapper userFoodTypeMapper, PostMapper postMapper1, RankPointLogMapper rankPointLogMapper1) {
    this.mojipMapper = mojipMapper;
    this.userInterestLogMapper = userInterestLogMapper;
    this.userFoodTypeMapper = userFoodTypeMapper;
    this.postMapper = postMapper1;
    this.rankPointLogMapper = rankPointLogMapper1;
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
  @Transactional
  public boolean deletePost(Long postSeq) {
    int result = postMapper.deletePost(postSeq);
    Long writerSeq = postMapper.selectWriterSeqByPostSeq(postSeq);
    int result2 = rankPointLogMapper.insertLog(writerSeq, "UNPOST");
    return result == 1 && result2 == 1;
  }

  @Override
  @Transactional
  public boolean createMojip(Long userSeq, String title, Date applyStartDate,
      Date applyEndDate, Date experienceDate, String content) {
    int result = mojipMapper.insertMojip(userSeq, title, applyStartDate, applyEndDate, experienceDate, content);
    int result2 = rankPointLogMapper.insertLog(userSeq, "POST");
    insertMojipLog(userSeq, title + " " + content);
    return result == 1 && result2 == 1;
  }

  @Override
  public boolean updateMojip(Long postSeq, String title, String content) {
   int result = mojipMapper.updateMojip(postSeq, title, content);
   return result == 1;
  }

  @Override
  @Transactional
  public boolean applyMojip(Long fromUserSeq, Long toUserSeq, Long fromPostSeq) {
    int result = mojipMapper.applyMojip(fromUserSeq, toUserSeq, fromPostSeq);
    insertApplyLog(fromUserSeq, toUserSeq);
    return result == 1;
  }

  private void insertSearchLog(Long requesterSeq, String searchWord) {
    Arrays.stream(FoodDish.values())
        .filter(food -> searchWord.contains(food.getCode()))
        .forEach(food -> userInterestLogMapper.insertInterestLog(requesterSeq, "SEARCH", food.getFoodType().getCode(), food.getCode()));
  }

  private void insertApplyLog(Long fromUserSeq, Long toUserSeq) {
    List<Map<String, Object>> foodTypes = userFoodTypeMapper.getUserFoodTypes(toUserSeq);

    foodTypes.stream()
        .forEach(foodType -> {
          userInterestLogMapper.insertInterestLog(fromUserSeq, "APPLY",
              (String) foodType.get("code"), (String) foodType.get("dish"));
        });
  }

  private void insertMojipLog(Long fromUserSeq, String text) {
    for (FoodDish dish : FoodDish.values()) {
      if (text.contains(dish.getCode())) {
        userInterestLogMapper.insertInterestLog(fromUserSeq, "POST", dish.getFoodType().getCode(), dish.getCode());
      }
    }
  }
}
