package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
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
    Long userSeq = 1L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-mojip-board";
  }

  //TODO: 모집글의 지원자 수 함께 보여주기
  @RequestMapping(value = "/{postSeq}", method = RequestMethod.GET)
  public String noticePostDetail(@PathVariable Long postSeq, Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 200L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    postService.addViewCount(postSeq);
    MojipPostDetailDTO mojipPost = mojipService.getMojipDetail(postSeq);

    model.addAttribute("mojipPost", mojipPost);
    model.addAttribute("loginUser", loginUser);

    return "common-mojip-detail";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String mojipCreatePage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 1L; // STORE
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "store-mojip-create";
  }
}
