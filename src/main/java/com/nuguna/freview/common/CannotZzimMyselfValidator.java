package com.nuguna.freview.common;

import com.nuguna.freview.common.dto.request.ZzimRequestDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CannotZzimMyselfValidator implements
    ConstraintValidator<CannotZzimMyself, ZzimRequestDTO> {

  @Override
  public boolean isValid(ZzimRequestDTO dto, ConstraintValidatorContext context) {
    if (dto == null) {
      return true; // null인 경우 검증 통과 (다른 검증에서 처리)
    }

    Long userSeq = dto.getUserSeq();
    Long toUserSeq = dto.getToUserSeq();

    // userSeq와 toUserSeq가 같으면 검증 실패
    return !userSeq.equals(toUserSeq);
  }
}