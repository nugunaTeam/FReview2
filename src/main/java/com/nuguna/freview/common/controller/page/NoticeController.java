package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
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
@RequestMapping("/notice")
public class NoticeController {

  private final UserService userService;
  private final PostService postService;

  @Autowired
  public NoticeController(UserService userService, PostService postService) {
    this.userService = userService;
    this.postService = postService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String noticeMainPage(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "common-notice-board";
  }

  @RequestMapping(value = "/{postSeq}", method = RequestMethod.GET)
  public String noticePostDetail(@PathVariable Long postSeq, Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);
    postService.addViewCount(postSeq);
    NoticeDetailResponseDTO currentPost = postService.getNoticeBySeq(postSeq);

    model.addAttribute("currentPost", currentPost);
    model.addAttribute("loginUser", loginUser);

    return "common-notice-detail";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String noticeCreate(Model model) {
    //HACK: 로그인 유저의 실제 seq 로 수정 필요
    Long userSeq = 301L;
    UserVO loginUser = userService.getUserInfo(userSeq);

    model.addAttribute("loginUser", loginUser);

    return "admin-notice-create";
  }
}
