package com.nuguna.freview.common.service.impl;

import com.nuguna.freview.admin.mapper.RankPointLogMapper;
import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.mapper.MojipMapper;
import com.nuguna.freview.common.mapper.PostMapper;
import com.nuguna.freview.common.service.MojipService;
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
  private final PostMapper postMapper;
  private final RankPointLogMapper rankPointLogMapper;

  @Autowired
  public MojipServiceImpl(MojipMapper mojipMapper, PostMapper postMapper, RankPointLogMapper rankPointLogMapper,
      PostMapper postMapper1, RankPointLogMapper rankPointLogMapper1) {
    this.mojipMapper = mojipMapper;
    this.postMapper = postMapper1;
    this.rankPointLogMapper = rankPointLogMapper1;
  }

  @Override
  public List<MojipPostDetailDTO> getMojipList(Long previousPostSeq, String searchWord, int pageSize) {
    if (searchWord == null || searchWord.isEmpty()) {
      return mojipMapper.selectMojipList(previousPostSeq, pageSize);
    } else {
      return mojipMapper.searchMojipList(previousPostSeq, pageSize, searchWord);
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
    return result == 1 && result2 == 1;
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
}
