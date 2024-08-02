package com.nuguna.freview.global.util;

import com.nuguna.freview.customer.dto.response.PaginationInfoResponseDTO;
import com.nuguna.freview.global.exception.IllegalPageAccessException;

public class PaginationUtil {

  public static PaginationInfoResponseDTO makePaginationViewInfo(int targetPage, int totalItemCount,
      int pageSize, int blockSize) {

    if (targetPage < 1) {
      throw new IllegalPageAccessException("페이지 번호는 1보다 커야 합니다.");
    }

    int offset = (targetPage - 1) * pageSize;
    if (offset > totalItemCount) {
      throw new IllegalPageAccessException("해당하는 페이지에 데이터가 존재하지 않습니다.");
    }

    // Block의 startPage
    int startPage = ((targetPage - 1) / blockSize) * blockSize + 1;
    // 현재 페이지에서 최대로 보여주는 페이지 사이즈
    int pageBlockThreshold = startPage + blockSize - 1;
    // Block의 endPage
    int endPage = Math.min(pageBlockThreshold,
        (int) Math.ceil((double) totalItemCount / pageSize));

    boolean hasNext = ((targetPage < endPage) || (totalItemCount
        > pageBlockThreshold * totalItemCount));
    boolean hasPrevious = (targetPage > 1);

    return new PaginationInfoResponseDTO(targetPage, startPage, endPage, hasNext, hasPrevious);
  }
}
