package com.joelotfy.marketplace.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.joelotfy.marketplace.vehicle.dto.CreateVehicleRequest;
import com.joelotfy.marketplace.vehicle.dto.UpdateVehicleRequest;
import com.joelotfy.marketplace.vehicle.dto.VehicleResponse;
import com.joelotfy.marketplace.vehicle.repository.VehicleRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import com.joelotfy.marketplace.vehicle.entity.Vehicle;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public VehicleResponse createVehicle(CreateVehicleRequest request){
        //map DTO to db entity
        Vehicle vehicleEntity = new Vehicle(
            //request is a DTO as a java record
            request.name(),
            request.description(),
            request.category(),
            request.dailyRate(),
            request.active()
        );

        //save to db
        Vehicle savedVehicle = vehicleRepository.save(vehicleEntity);
        
        //convert saved entity to a safe response DTO
        return new VehicleResponse(
            savedVehicle.getId(),   //savedEntity is a Vehicle Entity
            savedVehicle.getName(),
            savedVehicle.getCategory(),
            savedVehicle.getDailyRate()
        );
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);
    }

    //method for populating non-empty fields from an update requst into the entity
    private void updateVehicleFromDto(Vehicle vehicle, UpdateVehicleRequest dto) {
        if (dto.name() != null && !dto.name().isBlank()) {
            vehicle.setName(dto.name());
        }
        if (dto.description() != null && !dto.description().isBlank()) {
            vehicle.setDescription(dto.description());
        }
        if (dto.category() != null && !dto.description().isBlank()){
            vehicle.setCategory(dto.category());            
        }
        if (dto.dailyRate() != null) { // Numbers don't have .isBlank()
            vehicle.setDailyRate(dto.dailyRate());
        }
        if (dto.active() != null){
            vehicle.setActive(dto.active());
        }
    }

    @Transactional
    public VehicleResponse updateVehicle(UpdateVehicleRequest  request, Long id){
        //find the requested entity and error if it doesnt exist 
        Vehicle exisitingVehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"))
        ;
        
        //populate new edited data
        updateVehicleFromDto(exisitingVehicle, request);

        //return, Transactional boundary handles saving once i return
        return new VehicleResponse(
            exisitingVehicle.getId(),
            exisitingVehicle.getName(),
            exisitingVehicle.getCategory(),
            exisitingVehicle.getDailyRate()
        );
    }
}
