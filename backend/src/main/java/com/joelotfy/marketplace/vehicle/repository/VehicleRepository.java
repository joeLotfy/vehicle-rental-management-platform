package com.joelotfy.marketplace.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.joelotfy.marketplace.vehicle.entity.Vehicle;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> { //entity Vehicle managed by VehicleRepo, Long is Vehicle PK
    List<Vehicle> findByName(String name);

    Optional<Vehicle> findById(Long id);

    List<Vehicle> findByActive(boolean active);

    List<Vehicle> findByDailyRate(BigDecimal dailyRate);
    
    List<Vehicle> findByCategory(String category);

    List<Vehicle> findAll();

    List<Vehicle> findByDailyRateLessThanEqual(BigDecimal dailyRate);

    //and many others that are ready to use by extending JpaRepository
}
