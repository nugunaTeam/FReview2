package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.customer.dto.response.page.CustomerOtherBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import com.nuguna.freview.customer.service.CustomerUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class CommonPageController {

  private final CustomerPageService customerPageService;
  private final CustomerUtilService customerUtilService;

  @Autowired
  public CommonPageController(CustomerPageService customerPageService,
      CustomerUtilService customerUtilService) {
    this.customerPageService = customerPageService;
    this.customerUtilService = customerUtilService;
  }

  // TODO : 체험단, 사장님에 따라 다르게 랜더링 해주어야 함.
  @RequestMapping(value = "/brand/{userSeq}", method = RequestMethod.GET)
  public String customerOtherBrandPage(@PathVariable("userSeq") Long userSeq,
      @RequestParam Long fromUserSeq, Model model) {
    CustomerOtherBrandPageInfoResponseDTO otherBrandPageInfo = customerPageService.getOtherBrandPageInfo(
        userSeq);

    // TODO : 시큐리티로 변경 시, @AuthenticationPrincipal 에서 가져오는 작업 필요
    String userNickname = customerUtilService.getUserNickname(fromUserSeq);
    boolean isFromUserStore = customerUtilService.checkUserIsStore(fromUserSeq);
    boolean proposed = true;
    if (isFromUserStore) {
      proposed = customerUtilService.checkStoreProposedToUser(fromUserSeq, userSeq);
    }
    boolean zzimed = customerUtilService.checkZzimedOtherUser(fromUserSeq, userSeq);

    // userCode와 proposed 여부를 보내줘야함.

    model.addAttribute("otherBrandInfo", otherBrandPageInfo.getBrandInfo());
    model.addAttribute("reviewInfos", otherBrandPageInfo.getReviewInfos());
    model.addAttribute("reviewPageInfo", otherBrandPageInfo.getReviewPaginationInfo());
    model.addAttribute("userNickname", userNickname);
    model.addAttribute("isFromUserStore", isFromUserStore);
    model.addAttribute("proposed", proposed);
    model.addAttribute("zzimed", zzimed);
    model.addAttribute("fromUserSeq", fromUserSeq);
    return "customer-brand-info";
  }


}
