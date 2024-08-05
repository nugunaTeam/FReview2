package com.nuguna.freview.admin.service;

import com.nuguna.freview.admin.dto.DoneExperienceDTO;
import java.time.YearMonth;
import java.util.List;

public interface ExperienceService {

  List<DoneExperienceDTO> getDoneExperienceList(YearMonth yearMonth);
}
