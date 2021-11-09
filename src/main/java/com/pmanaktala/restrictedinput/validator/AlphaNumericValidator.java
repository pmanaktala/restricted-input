package com.pmanaktala.restrictedinput.validator;

import com.pmanaktala.restrictedinput.annotation.AlphaNumericInput;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphaNumericValidator implements ConstraintValidator<AlphaNumericInput, String> {

    @Override
    public void initialize(AlphaNumericInput constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     *
     * @param input The input
     * @param constraintValidatorContext Context
     * @return if input is valid or not
     */
    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isAlphanumeric(input);
    }
}
