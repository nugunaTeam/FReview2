package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

  private final UserService userService;

  @Autowired
  public BoardController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/notice", method = RequestMethod.GET)
  public String noticeBoardPage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-notice-board";
  }
}
