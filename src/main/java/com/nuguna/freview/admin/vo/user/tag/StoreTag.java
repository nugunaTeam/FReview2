package com.nuguna.freview.admin.vo.user.tag;

import com.nuguna.freview.common.exception.IllegalTagException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public class StoreTag extends TagItem {

  private static final List<String> storeTagNames = new ArrayList<>(
      Arrays.asList(
          "뷰 맛집",
          "오션뷰",
          "반려동물 환영")
  );

  public StoreTag(String tagName) {
    validateTagName(tagName);
    this.tagName = tagName;
    this.code = TagType.STORE;
  }

  @Override
  protected void validateTagName(String tagName) throws IllegalTagException {
    if (!storeTagNames.contains(tagName)) {
      throw new IllegalTagException("유효하지 않은 StoreTag 입력");
    }
  }
}
