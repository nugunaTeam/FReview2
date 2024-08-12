package com.nuguna.freview.customer.validation;


import com.nuguna.freview.customer.validation.annotation.ValidCustomerTags;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerTagsValidator implements ConstraintValidator<ValidCustomerTags, List<String>> {

  private static final List<String> ALLOWED_TAGS = Arrays.asList("초식", "육식", "맛집블로거", "정성리뷰어");

  @Override
  public boolean isValid(List<String> tags, ConstraintValidatorContext context) {
    if (tags == null) {
      return true; // null is valid, use @NotNull if needed
    }
    for (String tag : tags) {
      if (!ALLOWED_TAGS.contains(tag)) {
        return false;
      }
    }
    return true;
  }
}
