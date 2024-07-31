package com.nuguna.freview.store.controller.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.service.StoreActivityPageService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller

public class StoreActivityPageController {

  private final StoreActivityPageService storeActivityPageService;
  private final UserService userService;

  @Autowired
  public StoreActivityPageController(StoreActivityPageService storeActivityPageService,
      UserService userService) {
    this.storeActivityPageService = storeActivityPageService;
    this.userService = userService;
  }

  @RequestMapping("/store/activity")
  public String storeActivityPage(@RequestParam Long userSeq, Model model) throws JsonProcessingException {
    UserVO loginUser = userService.getUserInfo(userSeq);
    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
    List<StoreActivityWrittenPostResponseDTO> writtenPost = storeActivityPageService.storeActivityPageWrittenPost(userSeq);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("sendLike", sendLike);
    model.addAttribute("writtenPost", writtenPost);
    return "store-activity-page";
  }
}
