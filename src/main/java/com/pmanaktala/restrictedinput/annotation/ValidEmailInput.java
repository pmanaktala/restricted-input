package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.AlphaNumericValidator;
import com.pmanaktala.restrictedinput.validator.ValidEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * <p>
 * Checks if the Input contains only Unicode letters or digits. <br>
 * Uses StringUtils from apache for comparison.
 * </p>
 *
 * <p>{@code null} will return {@code false}.
 * An empty CharSequence (length()=0) will return {@code false}.</p>
 *
 * <pre>
 * StringUtils.isAlphanumeric(null)   = false
 * StringUtils.isAlphanumeric("")     = false
 * StringUtils.isAlphanumeric("  ")   = false
 * StringUtils.isAlphanumeric("abc")  = true
 * StringUtils.isAlphanumeric("ab c") = false
 * StringUtils.isAlphanumeric("ab2c") = true
 * StringUtils.isAlphanumeric("ab-c") = false
 * </pre>
 **/
@Documented
@Constraint(validatedBy = ValidEmailValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailInput {
    String message() default "Input is not alphameric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
