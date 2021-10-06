package com.pmanaktala.restrictedinput.validator;

import com.pmanaktala.restrictedinput.annotation.RestrictedInput;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class RestrictedInputValidator implements ConstraintValidator<RestrictedInput, String> {

    List<String> valuesToRestrict;
    List<String> regexToMatch;
    Boolean exactMatch;

    /**
     * {@inheritDoc}
     * @param restrictedInput The restricted input annotation.
     */
    @Override
    public void initialize(RestrictedInput restrictedInput) {
        valuesToRestrict = Arrays.asList(restrictedInput.valuesToRestrict());
        regexToMatch = Arrays.asList(restrictedInput.regexToMatch());
        exactMatch = restrictedInput.exactMatchValues();
    }

    /**
     * {@inheritDoc}
     *
     * @param field The field to validate
     * @param cxt Context
     * @return valid or not
     */
    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt) {
        return validRegex(field) && validFiledValue(field);
    }

    /**
     * Checks if the input has any restricted value or not
     *
     * @param field input
     * @return result
     */
    private boolean validFiledValue(String field) {
        if (valuesToRestrict.isEmpty() || isEmpty(field)) {
            return true;
        }

        if (exactMatch) {
            return valuesToRestrict.stream().noneMatch(field::equals);
        } else {
            return valuesToRestrict.stream().noneMatch(field::contains);
        }
    }

    /**
     * Checks if the input matches the given regex or not
     *
     * @param field input
     * @return result
     */
    private boolean validRegex(String field) {
        if (regexToMatch.isEmpty() || isEmpty(field)) {
            return true;
        }

        return regexToMatch.stream().allMatch(field::matches);
    }

}
