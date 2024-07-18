package com.nuguna.freview.admin.controller;

import com.nuguna.freview.admin.dto.request.StoreListRequestDTO;
import com.nuguna.freview.admin.dto.response.StoreListDTO;
import com.nuguna.freview.admin.dto.response.page.StoreManageResponseDTO;
import com.nuguna.freview.admin.service.AdminService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/store")
public class StoreManageApiController {
  private final AdminService adminService;
  private final Integer PAGE_SIZE = 30;

  @Autowired
  public StoreManageApiController(AdminService adminService) {
    this.adminService = adminService;
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public StoreManageResponseDTO getStoreList(@RequestBody StoreListRequestDTO requestDTO) {
    Long previousUserSeq = requestDTO.getPreviousUserSeq();
    String searchWord = requestDTO.getSearchWord();

    if (previousUserSeq == null) {
      previousUserSeq = Long.MAX_VALUE;
    }
    List<StoreListDTO> storeList = adminService.getStoreList(previousUserSeq, searchWord, PAGE_SIZE);
    boolean hasMore = storeList.size() == PAGE_SIZE;
    StoreManageResponseDTO responseDTO = StoreManageResponseDTO.builder()
        .storeList(storeList)
        .hasMore(hasMore)
        .build();

    return responseDTO;
  }
}
