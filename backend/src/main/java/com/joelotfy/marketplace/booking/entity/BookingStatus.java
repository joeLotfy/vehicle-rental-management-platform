package com.joelotfy.marketplace.booking.entity;

public enum BookingStatus {
    PENDING,    //not approved for or paid yet
    CONFIRMED,  //confirmed and vehicle reserved
    ACTIVE,     //rental in progress rn
    COMPLETED,  //vehicle returned and booking is finished
    CANCELLED,  //booking cancelled by user or system before starting
    REJECTED    //rejected by system or admin
}
