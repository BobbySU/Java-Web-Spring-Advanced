package com.example.ColaDistributionApp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = SecureKeyValidator.class)
public @interface SecureKeyValid {
    String message() default "SecureKey miss match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
