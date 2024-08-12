package com.nuguna.freview.common.controller.page;

import com.nuguna.freview.common.dto.response.MojipPostDetailDTO;
import com.nuguna.freview.common.service.MojipService;
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
@RequestMapping("/mojip")
public class MojipController {

  private final PostService postService;
  private final MojipService mojipService;

  @Autowired
  public MojipController(PostService postService,
      MojipService mojipService) {
    this.postService = postService;
    this.mojipService = mojipService;
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String mojipMainPage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "common-mojip-board";
  }

  @RequestMapping(value = "/{postSeq}", method = RequestMethod.GET)
  public String mojipPostDetail(@PathVariable Long postSeq, Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    postService.addViewCount(postSeq);
    MojipPostDetailDTO mojipPost = mojipService.getMojipDetail(postSeq);
    boolean isLiked = postService.isLikedPost(loginUser.getSeq(), postSeq);
    boolean isApplied = mojipService.isAppliedMojip(loginUser.getSeq(), postSeq);

    model.addAttribute("isLiked", isLiked);
    model.addAttribute("isApplied", isApplied);
    model.addAttribute("mojipPost", mojipPost);
    model.addAttribute("loginUser", loginUser);

    return "common-mojip-detail";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String mojipCreatePage(Model model) {
    UserVO loginUser = JwtContextHolder.getUserVO();
    model.addAttribute("loginUser", loginUser);

    return "store-mojip-create";
  }
}
