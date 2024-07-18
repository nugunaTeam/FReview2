package com.nuguna.freview.common.dto.response.page;

import com.nuguna.freview.common.dto.response.NoticeListDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDTO {

  private List<NoticeListDTO> noticeList;
  private int pageTotalCount;
}
