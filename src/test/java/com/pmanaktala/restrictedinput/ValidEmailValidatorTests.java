package com.pmanaktala.restrictedinput;

import com.pmanaktala.restrictedinput.validator.AlphaNumericValidator;
import com.pmanaktala.restrictedinput.validator.ValidEmailValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;

class ValidEmailValidatorTests {

    ValidEmailValidator validator = new ValidEmailValidator();

    @Mock
    private ConstraintValidatorContext ctx;

    @ParameterizedTest
    @ValueSource(strings = {"hello@example.com", "sam@yahoo.co.in", "someone@outlook.com"})
    void validParameters(String field) {
        Assertions.assertTrue(validator.isValid(field, ctx), "Expected successful" +
                " validation but validation failed");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc ", "", "@123"})
    void invalidParameters_ValuesToRestrict(String field) {
        Assertions.assertFalse(validator.isValid(field, ctx), "Expected failure" +
                " validation returned pass");
    }

}
