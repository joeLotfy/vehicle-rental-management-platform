package com.joelotfy.marketplace.customer.dto;
import java.time.LocalDate;

import com.joelotfy.marketplace.customer.annotation.MinAge;

import jakarta.validation.constraints.*;

public record CustomerResponse(

    @NotNull (message = "sorry we didn't get your firstname")
    String firstName,
    
    @NotNull (message = "sorry we didn't get your middlename")
    String middleName,

    @NotNull (message = "sorry we didn't get your lastname") 
    String lastName,

    @NotNull (message = "sorry we didn't get your nationality") 
    String nationality,

    @NotNull (message = "sorry we didn't get your national id number")
    String nationalID,

    @NotNull (message = "sorry we didn't get your gender")
    boolean sex,

    String Title,

    @NotBlank (message = "sorry we didnt get your e-mail address")
    @Email (message = "invalid email format")
    String email,
 
    @Past
    @NotNull (message = "looks like you didnt enter your data of birth")
    @MinAge(value = 18, message = "You must be at least 18 years old!!")
    LocalDate dateOfBirth,

    @NotNull (message = "sorry we didn't get your phone number") 
    @Size (min = 5, max = 30)
    String phoneNumber,

    @NotNull (message = "sorry we didn't get your address")
    String street,

    @NotNull (message = "sorry we didn't get your address")
    String city,

    @NotNull (message = "sorry we didn't get your address")
    String state,

    @Positive 
    Long zipCode,

    String licenseState,

    String licenseNumber,

    LocalDate licenseExpiryDate
) {}