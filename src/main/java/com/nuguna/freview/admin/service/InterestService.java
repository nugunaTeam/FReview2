package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.response.page.InterestStatsResponseDTO;
import java.util.List;

public interface InterestService {
  List<InterestStatsResponseDTO> getInterestStats();
}
