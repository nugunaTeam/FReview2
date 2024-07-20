package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import java.util.Date;
import java.util.List;

public interface MojipService {

  List<MojipPostDetailDTO> getMojipList(Long previousPostSeq, String searchWord, int pageSize);
  MojipPostDetailDTO getMojipDetail(Long postSeq);
  boolean createMojip(Long userSeq, String title, Date applyStartDate, Date applyEndDate, Date experienceDate, String content);
  boolean updateMojip(Long postSeq, String title, String content);
  boolean applyMojip(Long fromUserSeq, Long toUserSeq, Long fromPostSeq);
}
