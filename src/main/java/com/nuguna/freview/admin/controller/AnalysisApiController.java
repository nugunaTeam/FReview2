package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.DoneExperienceDTO;
import com.nuguna.freview.admin.service.ExperienceService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/analysis")
public class AnalysisApiController {

  private final ExperienceService experienceService;

  @Autowired
  public AnalysisApiController(ExperienceService experienceService) {
    this.experienceService = experienceService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public List<DoneExperienceDTO> getDoneExperienceList() {
    return experienceService.getDoneExperienceList();
  }
}
