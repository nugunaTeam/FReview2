package com.nuguna.freview.store.dto.response.page;

import com.nuguna.freview.store.dto.response.StoreActivitySendLikeResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivitySendZzimResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenPostResponseDTO;
import com.nuguna.freview.store.dto.response.StoreActivityWrittenReplyResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreActivityPageResponseDTO {

  private List<StoreActivitySendLikeResponseDTO> sendLikeList;
  private List<StoreActivitySendZzimResponseDTO> sendZzimList;
  private List<StoreActivityWrittenPostResponseDTO> writtenPostList;
  private List<StoreActivityWrittenReplyResponseDTO> writtenReplyList;
}
