package com.nuguna.freview.common.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
  int getDuplicatedEmail(String email);
}
