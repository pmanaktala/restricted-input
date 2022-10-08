package com.pmanaktala.restrictedinput.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.pmanaktala.restrictedinput.annotation.ValidPhone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidPhoneValidator.class);
    private String region;
    /**
     * Initializes the validator in preparation for
     * {@link #isValid(String, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param validPhone annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidPhone validPhone) {
        ConstraintValidator.super.initialize(validPhone);
        this.region = validPhone.region();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        PhoneNumberUtil phonenumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber number = phonenumberUtil.parse(value, region);
            return phonenumberUtil.isValidNumber(number);
        } catch (NumberParseException e) {
            LOGGER.error("Phone number or region incorrect", e);
            return false;
        }
    }
}
