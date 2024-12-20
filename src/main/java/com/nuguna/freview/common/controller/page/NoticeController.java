package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.page.NoticeDetailResponseDTO;
import com.nuguna.freview.common.service.NoticeService;
import com.nuguna.freview.common.service.PostService;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
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

  private final PostService postService;
  private final NoticeService noticeService;

  @Autowired
  public NoticeController(PostService postService,
      NoticeService noticeService) {
    this.postService = postService;
    this.noticeService = noticeService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String noticeMainPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "common-notice-board";
  }

  @RequestMapping(value = "/{postSeq}", method = RequestMethod.GET)
  public String noticePostDetail(@PathVariable Long postSeq, Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    postService.addViewCount(postSeq);
    NoticeDetailResponseDTO currentPost = noticeService.getNoticeBySeq(postSeq);

    model.addAttribute("currentPost", currentPost);
    model.addAttribute("loginUser", loginUser);

    return "common-notice-detail";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String noticeCreate(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "admin-notice-create";
  }
}
