package com.pmanaktala.restrictedinput.validator;

import com.pmanaktala.restrictedinput.annotation.RestrictedInput;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RestrictedInputValidator implements ConstraintValidator<RestrictedInput, String> {

    public void initialize(RestrictedInput restrictedInput) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {

        return contactField != null && contactField.matches("[0-9]+") && (contactField.length() > 8) && (contactField.length() < 14);
    }

}
