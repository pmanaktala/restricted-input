package com.pmanaktala.restrictedinput;

import com.pmanaktala.restrictedinput.annotation.RestrictedInput;
import com.pmanaktala.restrictedinput.validator.AlphaNumericValidator;
import com.pmanaktala.restrictedinput.validator.RestrictedInputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;

import static org.mockito.Mockito.when;

class AlphaNumericValidatorTests {

    AlphaNumericValidator validator = new AlphaNumericValidator();

    @Mock
    private ConstraintValidatorContext ctx;

    @ParameterizedTest
    @ValueSource(strings = {"abc", "123", "abc123"})
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
