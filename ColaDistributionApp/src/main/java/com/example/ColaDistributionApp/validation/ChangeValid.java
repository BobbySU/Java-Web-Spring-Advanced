package com.example.ColaDistributionApp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = ChangeValidator.class)
public @interface ChangeValid {

    String message() default "Password miss match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
