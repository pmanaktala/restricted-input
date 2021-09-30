package com.pmanaktala.restrictedinput.annotation;

import com.pmanaktala.restrictedinput.validator.RestrictedInputValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RestrictedInputValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestrictedInput {
    String message() default "Invalid input!";

    /**
     *
     * Specify a list of values that should not present in the given input.
     * It does a 'contains' operation, and if any of the value is found in input,
     * it fails the validation.
     *
     * @return values to restrict
     */
    String[] valuesToRestrict();

    /**
     * Specify a list of regular expression that the input should MATCH to.
     * If any of the regex does not match the input, the validation fails.
     *
     * @return regex to match
     */
    String[] regexToMatch();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
