package com.joelotfy.marketplace.customer.dto;

import java.time.LocalDate;

import com.joelotfy.marketplace.customer.annotation.MinAge;
import java.lang.Boolean;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record PatchCustomerRequest(
    
    @Size (min = 2, max = 30)
    String firstName,
    
    @Size (min = 0, max = 80)
    String middleName,

    @Size (min = 2, max = 30)
    String lastName,

    String nationality,

    String nationalID,

    Boolean sex,

    String title,

    @Email (message = "invalid email format")
    String email,
 
    @Past
    @MinAge(value = 18, message = "You must be at least 18 years old!!")
    LocalDate dateOfBirth,

    @Size (min = 5, max = 30)
    String phoneNumber,

    String street,

    String city,

    String state,

    Long zipCode,

    String licenseState,

    String licenseNumber,

    LocalDate licenseExpiryDate
) {}
