package com.tea4e.vehicleindexbackend.service.impl;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.entity.GroundVehicle;
import com.tea4e.vehicleindexbackend.repo.GroundVehicleRepo;
import com.tea4e.vehicleindexbackend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService {

    GroundVehicleRepo groundRepo;

    @Autowired
    public void setGroundRepo(GroundVehicleRepo groundRepo) {
        this.groundRepo = groundRepo;
    }

    @Override
    public void createVehicle(CreateVehicleRequest request) {

        GroundVehicle entity = request2Entity(request);
        GroundVehicle result = groundRepo.save(entity);

    }

    private GroundVehicle request2Entity(CreateVehicleRequest request){
        return GroundVehicle.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
