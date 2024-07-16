package com.nuguna.freview.admin.vo.user.tag;

import com.nuguna.freview.common.exception.IllegalTagException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class TagItem {

  protected TagType code;
  protected String tagName;

  protected abstract void validateTagName(String tagName) throws IllegalTagException;

  public boolean isCustomerTag() {
    return code.isCustomerTag();
  }

  public boolean isStoreTag() {
    return code.isStoreTag();
  }
}