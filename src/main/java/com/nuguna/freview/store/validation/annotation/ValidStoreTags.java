package com.nuguna.freview.store.validation.annotation;

import com.nuguna.freview.store.validation.StoreTagsValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = StoreTagsValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStoreTags {

  String message() default "유효하지 않은 스토어 태그입니다.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
