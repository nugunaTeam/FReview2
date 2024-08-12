package com.nuguna.freview.admin.controller;

import static com.nuguna.freview.admin.constant.ManagementPageConstant.STORE_MANAGEMENT_PAGE_SIZE;

import com.nuguna.freview.admin.dto.request.StoreListRequestDTO;
import com.nuguna.freview.admin.dto.response.StoreInfoDTO;
import com.nuguna.freview.admin.dto.response.page.StoreManageResponseDTO;
import com.nuguna.freview.admin.service.AdminService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/store")
public class StoreManageApiController {
  private final AdminService adminService;

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
    List<StoreInfoDTO> storeList = adminService.getStoreList(previousUserSeq, searchWord, STORE_MANAGEMENT_PAGE_SIZE);
    boolean hasMore = storeList.size() == STORE_MANAGEMENT_PAGE_SIZE;
    StoreManageResponseDTO responseDTO = new StoreManageResponseDTO();
    responseDTO.setStoreList(storeList);
    responseDTO.setHasMore(hasMore);

    return responseDTO;
  }

  @RequestMapping(value = "/{deleteUserSeq}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteStore(@PathVariable Long deleteUserSeq,
      @RequestParam String adminVerificationPW,
      @RequestParam Long adminSeq) {
    try {
      adminService.deleteUser(adminSeq, adminVerificationPW, deleteUserSeq);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    } catch (IllegalStateException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
