package com.wuliangit.shopos.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageValidator.class)
public @interface Page {

    int value() default 1;

    String message() default "页码有错";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}