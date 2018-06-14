package com.studbaza.baza.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HourSimpleValidator implements ConstraintValidator<HoursValidatorConstraint, String> {

    @Override
    public void initialize(HoursValidatorConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
                && (value.length() >4) && (value.length() <6);
    }
}

