package com.joelotfy.marketplace.customer.dto;

import java.time.LocalDate;
import com.joelotfy.marketplace.customer.annotation.MinAge;
import jakarta.validation.constraints.*;

public record CreateCustomerRequest(

    @NotBlank
    @NotNull 
    @Size (min = 2, max = 30)
    String firstName,
    
    @Size (min = 0, max = 80)
    String middleName,

    @NotBlank
    @NotNull 
    @Size (min = 2, max = 30)
    String lastName,

    @NotBlank 
    String nationality,

    @NotNull
    @NotBlank
    String nationalID,

    @NotNull 
    boolean sex,

    String Title,

    @NotBlank (message = "Email is required")
    @Email (message = "invalid email format")
    String email,
 
    @Past
    @NotNull
    @MinAge(value = 18, message = "You must be at least 18 years old!!")
    LocalDate dateOfBirth,

    @NotNull 
    @Size (min = 5, max = 30)
    String phoneNumber,

    @NotNull 
    String street,

    @NotNull 
    String city,

    @NotNull 
    String state,

    Long zipCode,

    String licenseState,

    String licenseNumber,

    LocalDate licenseExpiryDate
) {}