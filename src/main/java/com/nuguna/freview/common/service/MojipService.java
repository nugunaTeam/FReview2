package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.MojipPostDTO;
import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import java.util.Date;
import java.util.List;

public interface MojipService {

  List<MojipPostDTO> getMojipList(Long requesterSeq, Long previousPostSeq, String searchWord, int pageSize);
  MojipPostDetailDTO getMojipDetail(Long postSeq);
  boolean createMojip(Long userSeq, String title, Date applyStartDate, Date applyEndDate, Date experienceDate, String content);
  boolean updateMojip(Long postSeq, String title, String content);
  boolean applyMojip(Long fromUserSeq, Long toUserSeq, Long fromPostSeq);
  boolean deletePost(Long postSeq);
  boolean isAppliedMojip(Long userSeq, Long postSeq);
}
