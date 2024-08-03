package com.nuguna.freview.store.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.global.exception.IllegalPageAccessException;
import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.service.StoreActivityPageService;
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
// 수정전
//  @RequestMapping("/store/activity")
//  public String storeActivityPage(@RequestParam Long userSeq, Model model) throws IllegalPageAccessException {
//    UserVO loginUser = userService.getUserInfo(userSeq);
//    List<StoreActivitySendLikeResponseDTO> sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq);
//    List<StoreActivityWrittenPostResponseDTO> writtenPost = storeActivityPageService.storeActivityPageWrittenPost(userSeq);
//    model.addAttribute("loginUser", loginUser);
//    model.addAttribute("sendLike", sendLike);
//    model.addAttribute("writtenPost", writtenPost);
//    return "store-activity-page";
//  }

  @RequestMapping("/store/activity")
  public String storeActivityPage(@RequestParam Long userSeq, Model model,
                                  @RequestParam Integer targetPage)
      throws IllegalPageAccessException {
    UserVO loginUser = userService.getUserInfo(userSeq);

    StoreActivitySendLikeResponseDTO sendLike = storeActivityPageService.storeActivityPageSendLike(userSeq, targetPage);
    StoreActivityWrittenPostResponseDTO writtenPost = storeActivityPageService.storeActivityPageWrittenPost(userSeq, targetPage);

    model.addAttribute("loginUser", loginUser);
    model.addAttribute("sendLike", sendLike);
    model.addAttribute("writtenPost", writtenPost);
    return "store-activity-page";
  }
}
