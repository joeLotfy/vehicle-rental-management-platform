package com.joelotfy.marketplace.customer.validation;

import com.joelotfy.marketplace.customer.annotation.MinAge;
import jakarta.validation.*;
import java.time.LocalDate;
import java.time.Period;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {
    private int minAge;

    @Override 
    public void initialize(MinAge constraintAnnotation){
        this.minAge = constraintAnnotation.value();
    }

    @Override 
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        //let @NotNull handle missing fields so this validator doesn't crash on null
        if (dateOfBirth == null){return true;}
        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= minAge;
    }
}
