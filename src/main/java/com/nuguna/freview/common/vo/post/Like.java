package com.nuguna.freview.common.vo.post;

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
public class Like {

  private Long seq;
  private Long userSeq;
  private Long postSeq;
  private Timestamp createdAt;
}