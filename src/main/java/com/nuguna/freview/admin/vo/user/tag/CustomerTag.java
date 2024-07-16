package com.nuguna.freview.admin.vo.user.tag;

import com.nuguna.freview.common.exception.IllegalTagException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class CustomerTag extends TagItem {

  private static final List<String> customerTagNames = new ArrayList<>(
      Arrays.asList(
          "초식",
          "육식",
          "맛집블로거",
          "정성리뷰어")
  );

  public CustomerTag(String tagName) {
    validateTagName(tagName);
    this.tagName = tagName;
    this.code = TagType.CUSTOMER;
  }

  @Override
  protected void validateTagName(String tagName) throws IllegalTagException {
    if (!customerTagNames.contains(tagName)) {
      throw new IllegalTagException("유효하지 않은 CustomerTag 입력");
    }
  }
}
