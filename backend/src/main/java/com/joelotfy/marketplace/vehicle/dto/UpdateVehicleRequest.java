package com.joelotfy.marketplace.vehicle.dto;

import java.math.BigDecimal;
import java.lang.Boolean;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateVehicleRequest(
    
    
    @Size(min=2, max=100)
    String name,

    @Size(min=2, max=2500)
    String description,

    @Size(min=2, max=100)
    String category,

    @Positive(message = "Rate must be greater than zero")
    BigDecimal dailyRate,

    @NotNull
    Boolean active
) {}
