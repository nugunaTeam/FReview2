package com.nuguna.freview.store.validation;


import com.nuguna.freview.store.validation.annotation.ValidStoreTags;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StoreTagsValidator implements ConstraintValidator<ValidStoreTags, List<String>> {

  private static final List<String> ALLOWED_TAGS = Arrays.asList("뷰 맛집", "오션뷰", "반려동물 환영");

  @Override
  public boolean isValid(List<String> tags, ConstraintValidatorContext context) {
    if (tags == null) {
      return true;
    }
    for (String tag : tags) {
      if (!ALLOWED_TAGS.contains(tag)) {
        return false;
      }
    }
    return true;
  }
}
