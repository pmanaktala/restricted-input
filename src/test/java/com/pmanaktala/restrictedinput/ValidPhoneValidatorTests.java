package com.pmanaktala.restrictedinput;

import com.pmanaktala.restrictedinput.annotation.ValidPhone;
import com.pmanaktala.restrictedinput.validator.ValidPhoneValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;

class ValidPhoneValidatorTests {

    ValidPhoneValidator validator = new ValidPhoneValidator();
    private final ValidPhone validPhone = Mockito.mock(ValidPhone.class);

    @Mock
    private ConstraintValidatorContext ctx;

    @ParameterizedTest
    @ValueSource(strings = {"2602651234", "+12602651234", "5417543010"})
    void validPhoneNumberTest_Success(String number) {
        Mockito.when(validPhone.region()).thenReturn("US");

        validator.initialize(validPhone);
        Assertions.assertTrue(validator.isValid(number, ctx), "Expected successful" +
                " validation but validation failed");
    }

    @ParameterizedTest
    @CsvSource({"9001234567,US", "+19001234567,IN"})
    void validPhoneNumberTest_Success(String number, String region) {
        Mockito.when(validPhone.region()).thenReturn(region);
        validator.initialize(validPhone);

        Assertions.assertFalse(validator.isValid(number, ctx), "Expected failure" +
                " validation returned pass");
    }

}
