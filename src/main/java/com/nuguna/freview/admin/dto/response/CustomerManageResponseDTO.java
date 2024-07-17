package com.nuguna.freview.admin.dto.response;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerManageResponseDTO {

  private Long seq;
  private String code;
  private String nickname;
  private String email;
  private Timestamp createdAt;
}
