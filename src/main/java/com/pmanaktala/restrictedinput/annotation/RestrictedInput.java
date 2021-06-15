package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.RestrictedInputValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = RestrictedInputValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RestrictedInput {
    String message() default "Invalid input!";
    String[] ignoredValues();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
