package com.tea4e.vehicleindexbackend.service;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.repo.GroundVehicleRepo;

public interface VehicleService {
    void createVehicle(CreateVehicleRequest request);
}
