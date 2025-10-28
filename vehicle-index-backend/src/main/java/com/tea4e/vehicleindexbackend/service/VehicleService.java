package com.tea4e.vehicleindexbackend.service;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleBatchRequest;
import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.repo.GroundVehicleRepo;

public interface VehicleService {
    void createVehicle(String id, CreateVehicleRequest request);

    void createVehicleBatch(CreateVehicleBatchRequest batchRequest);
}
