package com.nuguna.freview.common.service;

import com.nuguna.freview.common.dto.response.MojipPostDTO;
import java.util.List;

public interface MojipService {

  List<MojipPostDTO> getMojipList(Long previousPostSeq, String searchWord, int pageSize);
}
