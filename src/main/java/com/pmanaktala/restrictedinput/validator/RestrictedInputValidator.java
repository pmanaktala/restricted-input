package com.pmanaktala.restrictedinput.validator;

import com.pmanaktala.restrictedinput.annotation.RestrictedInput;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class RestrictedInputValidator implements ConstraintValidator<RestrictedInput, String> {

    List<String> valuesToRestrict;
    List<String> regexToMatch;


    @Override
    public void initialize(RestrictedInput restrictedInput) {
        valuesToRestrict = Arrays.asList(restrictedInput.valuesToRestrict());
        regexToMatch = Arrays.asList(restrictedInput.regexToMatch());
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt) {
        return validRegex(field) && validFiledValue(field);
    }

    private boolean validFiledValue(String field) {
        if(valuesToRestrict.isEmpty() || isEmpty(field)) {
            return true;
        }

        return valuesToRestrict.stream().noneMatch(field::contains);
    }

    private boolean validRegex(String field) {
        if(regexToMatch.isEmpty() || isEmpty(field)) {
            return true;
        }

        return regexToMatch.stream().allMatch(field::matches);
    }

}
