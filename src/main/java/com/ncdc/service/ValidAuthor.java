package com.ncdc.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AuthorValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAuthor {

    String message() default "Author name or surname must start from 'A'.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
