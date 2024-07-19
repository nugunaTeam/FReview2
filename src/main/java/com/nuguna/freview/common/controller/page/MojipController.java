package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.MojipPostDTO;
import com.nuguna.freview.common.service.MojipService;
import com.nuguna.freview.common.service.PostService;
import com.nuguna.freview.common.service.UserService;
import com.nuguna.freview.common.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/mojip")
public class MojipController {

  private final UserService userService;
  private final PostService postService;
  private final MojipService mojipService;

  @Autowired
  public MojipController(UserService userService, PostService postService,
      MojipService mojipService) {
    this.userService = userService;
    this.postService = postService;
    this.mojipService = mojipService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String mojipMainPage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-mojip-board";
  }

  @RequestMapping(value = "/{postSeq}", method = RequestMethod.GET)
  public String noticePostDetail(@PathVariable Long postSeq, Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    postService.addViewCount(postSeq);
    MojipPostDTO mojipPost = mojipService.getMojipDetail(postSeq);

    model.addAttribute("mojipPost", mojipPost);
    model.addAttribute("loginUser", loginUser);

    return "common-mojip-detail";
  }
}
