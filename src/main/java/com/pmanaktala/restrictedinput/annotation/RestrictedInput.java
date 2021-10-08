package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.RestrictedInputValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Checks if the input is valid against the restrictedValue or validRegex Patterns.
 */
@Documented
@Constraint(validatedBy = RestrictedInputValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestrictedInput {
    String message() default "Invalid input!";

    /**
     *
     * Specify a list of values that should not present in the given input.
     * If any of the value is found in input, it fails the validation.
     *
     * @return values to restrict
     */
    String[] valuesToRestrict() default {};

    /**
     * If true the exact match of the values with the input is done,
     * if set to false then a contains check is done.
     * @return if exact match or not
     */
    boolean exactMatchValues() default false;

    /**
     * Specify a list of regular expression that the input should MATCH to.
     * If any of the regex does not match the input, the validation fails.
     *
     * @return regex to match
     */
    String[] regexToMatch() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
