package com.joelotfy.marketplace.booking.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.joelotfy.marketplace.customer.entity.Customer;
import com.joelotfy.marketplace.vehicle.entity.Vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "bookings")
@Getter 
@Setter 
@Builder 
@AllArgsConstructor(access = AccessLevel.PRIVATE) 
@NoArgsConstructor //required by jpa
public class Booking {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter (AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false) //specifies the FK columns in bookings
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column (nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column (nullable = false, name = "end_date")
    private LocalDate endDate;

    @Column (nullable = false, name = "price_snapshot", precision = 10, scale = 2)
    private BigDecimal priceSnapshot;

    @Column (nullable = false, name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private BookingStatus status;
}
