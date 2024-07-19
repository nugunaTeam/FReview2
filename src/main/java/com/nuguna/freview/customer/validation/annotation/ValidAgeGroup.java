package com.nuguna.freview.customer.validation.annotation;

import com.nuguna.freview.customer.validation.AgeGroupValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AgeGroupValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAgeGroup {

  String message() default "유효하지 않은 연령대입니다.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}