package com.nuguna.freview.admin.mapper;

import com.nuguna.freview.admin.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {

  public AdminVO selectAdmin(Long userSeq);
}
