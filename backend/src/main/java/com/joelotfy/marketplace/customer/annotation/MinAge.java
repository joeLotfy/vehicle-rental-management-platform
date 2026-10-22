package com.joelotfy.marketplace.customer.annotation;

import com.joelotfy.marketplace.customer.validation.MinAgeValidator;
import jakarta.validation.*;
import java.lang.annotation.*;

@Target ({ElementType.FIELD, ElementType.METHOD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = MinAgeValidator.class) //links annotation to the calculator
@Documented
public @interface MinAge {
    String message() default "You must be at least 18 years old!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value() default 18;
}