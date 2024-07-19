package com.nuguna.freview.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CannotZzimMyselfValidator.class)
public @interface CannotZzimMyself {

  String message() default "자기 자신을 찜할 수 없습니다.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}