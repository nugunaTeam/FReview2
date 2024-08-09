package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.MainPageCustomerMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageMojipMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageMojipSimpleDateDTO;
import com.nuguna.freview.common.dto.response.MainPageRecentGongjiMapperDTO;
import com.nuguna.freview.common.dto.response.MainPageRecentGongjiSimpleDateDTO;
import com.nuguna.freview.common.dto.response.page.MainPageGongjiResponseDTO;
import com.nuguna.freview.common.dto.response.page.MainPageHotCustomerResponseDTO;
import com.nuguna.freview.common.dto.response.page.MainPageHotMojipResponseDTO;
import com.nuguna.freview.common.service.MainPageService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/main-page")
public class MainPageController {

  private final MainPageService mainPageService;

  @Autowired
  public MainPageController(MainPageService mainPageService) {
    this.mainPageService = mainPageService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String goToMainPage(Model model) {

    UserVO uvo = JwtContextHolder.getUserVO();

    List<MainPageMojipMapperDTO> mojips = mainPageService.getHotMojipList();
    List<MainPageCustomerMapperDTO> customers = mainPageService.getHotCustomerList();
    List<MainPageRecentGongjiMapperDTO> gongjis = mainPageService.getRecentGongjiList();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    List<MainPageMojipSimpleDateDTO> mojipsSimpleDate = new ArrayList<MainPageMojipSimpleDateDTO>();
    for (MainPageMojipMapperDTO mojip : mojips) {
      String applyEndDate = sdf.format(mojip.getApplyEndDate());
      String applyStartDate = sdf.format(mojip.getApplyStartDate());
      String experienceDate = sdf.format(mojip.getExperienceDate());
      MainPageMojipSimpleDateDTO mojipSimple = new MainPageMojipSimpleDateDTO(
          mojip.getPostSeq(), mojip.getTitle(), applyStartDate, applyEndDate, experienceDate,
          mojip.getProfilePhotoUrl(), mojip.getStoreLocation(), mojip.getStoreName());
      mojipsSimpleDate.add(mojipSimple);
    }

    List<MainPageRecentGongjiSimpleDateDTO> gongjisSimpleDate = new ArrayList<MainPageRecentGongjiSimpleDateDTO>();
    for (MainPageRecentGongjiMapperDTO gongji : gongjis) {
      String createdAt = sdf.format(gongji.getCreatedAt());
      String updatedAt = sdf.format(gongji.getUpdatedAt());
      MainPageRecentGongjiSimpleDateDTO gongjiSimple = new MainPageRecentGongjiSimpleDateDTO(
          gongji.getSeq(), gongji.getTitle(), createdAt, updatedAt);
      gongjisSimpleDate.add(gongjiSimple);
    }

    MainPageHotMojipResponseDTO mojipdto = new MainPageHotMojipResponseDTO(mojipsSimpleDate);
    MainPageHotCustomerResponseDTO customerdto = new MainPageHotCustomerResponseDTO(customers);
    MainPageGongjiResponseDTO gonggidto = new MainPageGongjiResponseDTO(gongjisSimpleDate);

    model.addAttribute("mojips", mojipdto);
    model.addAttribute("customers", customerdto);
    model.addAttribute("gongjis", gonggidto);

    if (uvo != null) {
      if (uvo.getCode().equals("CUSTOMER")) {
        return "customer-mainpage";
      } else if (uvo.getCode().equals("STORE")) {
        return "store-mainpage";
      } else {
        return "forward: /admin";
      }
    }
      return "common-mainpage";
  }
}
