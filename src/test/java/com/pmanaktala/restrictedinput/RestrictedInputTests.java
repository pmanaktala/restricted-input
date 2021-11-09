package com.pmanaktala.restrictedinput;

import com.pmanaktala.restrictedinput.annotation.RestrictedInput;
import com.pmanaktala.restrictedinput.validator.RestrictedInputValidator;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;

import static org.mockito.Mockito.when;

class RestrictedInputTests {

    RestrictedInputValidator validator = new RestrictedInputValidator();

    @Mock
    private ConstraintValidatorContext ctx;

    private final RestrictedInput restrictedInput = Mockito.mock(RestrictedInput.class);

    @ParameterizedTest
    @CsvSource(value = {"test, abc, null , true", "null, null, null, false"}, nullValues = "null" )
    void validParameters(String field, String value, String pattern, Boolean exactMatch) {

        when(restrictedInput.valuesToRestrict()).thenReturn(new String[]{value});
        when((restrictedInput.regexToMatch())).thenReturn(new String[]{pattern});
        when(restrictedInput.exactMatchValues()).thenReturn(exactMatch);

        validator.initialize(restrictedInput);
        Assertions.assertTrue(validator.isValid(field, ctx), "Expected successful a" +
                " validation but validation failed");
    }

    @ParameterizedTest
    @CsvSource(value = {"test, test, null , true", "test, te, null, false"}, nullValues = "null" )
    void invalidParameters_ValuesToRestrict(String field, String value, String pattern, Boolean exactMatch) {

        when(restrictedInput.valuesToRestrict()).thenReturn(new String[]{value});
        when((restrictedInput.regexToMatch())).thenReturn(new String[]{pattern});
        when(restrictedInput.exactMatchValues()).thenReturn(exactMatch);

        validator.initialize(restrictedInput);
        Assertions.assertFalse(validator.isValid(field, ctx), "Expected failure" +
                " validation returned pass");
    }

    @ParameterizedTest
    @CsvSource(value = {"11, test, true"}, nullValues = "null" )
    void invalidParameters_RegexFail(String field, String value, Boolean exactMatch) {

        when(restrictedInput.valuesToRestrict()).thenReturn(new String[]{value});
        when((restrictedInput.regexToMatch())).thenReturn(new String[]{"^[a-zA-Z]*$"});
        when(restrictedInput.exactMatchValues()).thenReturn(exactMatch);

        validator.initialize(restrictedInput);
        Assertions.assertFalse(validator.isValid(field, ctx), "Expected failure" +
                " validation returned pass");
    }

}
