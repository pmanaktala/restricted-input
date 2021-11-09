package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.AlphaNumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * <p>
 * Checks if the Input is a valid email or not.<br>
 * Uses Apache Commons for validation
 **/
@Documented
@Constraint(validatedBy = AlphaNumericValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphaNumericInput {
    String message() default "Input is not valid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
