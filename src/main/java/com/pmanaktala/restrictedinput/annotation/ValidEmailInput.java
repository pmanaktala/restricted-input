package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.AlphaNumericValidator;
import com.pmanaktala.restrictedinput.validator.ValidEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * <p>
 * Checks if the Input contains valid email or not <br>
 * Uses apache commons for validation
 **/
@Documented
@Constraint(validatedBy = ValidEmailValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailInput {
    String message() default "Input is not a valid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
