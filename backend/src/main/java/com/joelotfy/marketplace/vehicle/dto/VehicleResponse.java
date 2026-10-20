package com.joelotfy.marketplace.vehicle.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public record VehicleResponse(
    @NotNull(message = "seems like the db didn't create an ID")
    Long id,

    
    String name,
    String category,
    
    @Positive(message = "response rate must grater than zero")
    BigDecimal dailyRate
) {}
