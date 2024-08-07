package com.nuguna.freview.admin.service.impl;

import com.nuguna.freview.admin.dto.DoneExperienceDTO;
import com.nuguna.freview.admin.mapper.DoneExperienceAccumulationMapper;
import com.nuguna.freview.admin.service.ExperienceService;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements ExperienceService {

  private final DoneExperienceAccumulationMapper doneExperienceAccumulationMapper;

  @Autowired
  public ExperienceServiceImpl(DoneExperienceAccumulationMapper doneExperienceAccumulationMapper) {
    this.doneExperienceAccumulationMapper = doneExperienceAccumulationMapper;
  }

  @Override
  public List<DoneExperienceDTO> getDoneExperienceList(YearMonth yearMonth) {
    LocalDate startDate = yearMonth.atDay(1);
    LocalDate endDate = yearMonth.atEndOfMonth();
    List<DoneExperienceDTO> list = doneExperienceAccumulationMapper.findByDateBetween(startDate, endDate);

    list.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

    if (!list.isEmpty()) {
      startDate = list.get(0).getDate();
      endDate = list.get(list.size() - 1).getDate();

      List<DoneExperienceDTO> completeList = new ArrayList<>();
      LocalDate currentDate = startDate;

      int index = 0;
      while (!currentDate.isAfter(endDate)) {
        if (index < list.size() && list.get(index).getDate().equals(currentDate)) {
          completeList.add(list.get(index));
          index++;
        } else {
          completeList.add(new DoneExperienceDTO(currentDate, 0L));
        }
        currentDate = currentDate.plusDays(1);
      }

      list = completeList;
    }

    return list;
  }
}
