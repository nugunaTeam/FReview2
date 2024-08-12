package com.nuguna.freview.customer.controller.page;

import com.nuguna.freview.common.vo.user.UserCode;
import com.nuguna.freview.common.vo.user.UserVO;
import com.nuguna.freview.customer.dto.response.page.CustomerOtherBrandPageInfoResponseDTO;
import com.nuguna.freview.customer.service.CustomerPageService;
import com.nuguna.freview.customer.service.OtherBrandPageUtilService;
import com.nuguna.freview.security.jwtfilter.JwtContextHolder;
import com.nuguna.freview.store.dto.response.StoreBrandInfoResponseDTO;
import com.nuguna.freview.store.service.StoreBrandPageService;
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
  private final StoreBrandPageService storeBrandPageService;
  private final OtherBrandPageUtilService otherBrandPageUtilService;

  @Autowired
  public CommonPageController(CustomerPageService customerPageService,
      StoreBrandPageService storeBrandPageService,
      OtherBrandPageUtilService otherBrandPageUtilService) {
    this.customerPageService = customerPageService;
    this.storeBrandPageService = storeBrandPageService;
    this.otherBrandPageUtilService = otherBrandPageUtilService;
  }

  @RequestMapping(value = "/brand/{userSeq}", method = RequestMethod.GET)
  public String customerOtherBrandPage(@PathVariable("userSeq") Long userSeq, Model model) {

    Long fromUserSeq = JwtContextHolder.getUserVO().getSeq();
    UserCode targetUserCode = otherBrandPageUtilService.getUserCode(userSeq);

    boolean zzimed = otherBrandPageUtilService.checkZzimedOtherUser(fromUserSeq, userSeq);
    boolean isFromUserStore = otherBrandPageUtilService.checkUserIsStore(fromUserSeq);
    String userNickname;
    if(isFromUserStore){
      userNickname = otherBrandPageUtilService.getStoreName(fromUserSeq);
    } else {
      userNickname = otherBrandPageUtilService.getUserNickname(fromUserSeq);
    }

    model.addAttribute("zzimed", zzimed);
    model.addAttribute("fromUserSeq", fromUserSeq);
    model.addAttribute("isFromUserStore", isFromUserStore);
    model.addAttribute("userNickname", userNickname);

    if(targetUserCode.isCustomer()){
      CustomerOtherBrandPageInfoResponseDTO otherBrandPageInfo = customerPageService.getOtherBrandPageInfo(
          userSeq);
      boolean proposed = true;
      if (isFromUserStore) {
        proposed = otherBrandPageUtilService.checkStoreProposedToUser(fromUserSeq, userSeq);
      }
      model.addAttribute("otherBrandInfo", otherBrandPageInfo.getBrandInfo());
      model.addAttribute("reviewInfos", otherBrandPageInfo.getReviewInfos());
      model.addAttribute("reviewPageInfo", otherBrandPageInfo.getReviewPaginationInfo());
      model.addAttribute("proposed", proposed);
      return "customer-brand-info";
    } else if(targetUserCode.isStore()) {
      StoreBrandInfoResponseDTO storeBrandInfoResponseDTO = storeBrandPageService.getMyBrandPageInfo(userSeq);
      model.addAttribute("otherBrandInfo", storeBrandInfoResponseDTO);
      return "store-brand-info";
    }
    return "cust_main";
  }


}
