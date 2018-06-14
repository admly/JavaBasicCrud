package com.studbaza.baza.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HourSimpleValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HoursValidatorConstraint {
    String message() default "Błędny format godziny. Poprawny format to HH:MM";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
