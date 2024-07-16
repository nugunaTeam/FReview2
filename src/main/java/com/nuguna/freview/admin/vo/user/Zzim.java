package com.nuguna.freview.admin.vo.user;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Zzim {

  private Long seq;
  private Long fromUserSeq;
  private Long toUserSeq;
  private Timestamp createdAt;
}
