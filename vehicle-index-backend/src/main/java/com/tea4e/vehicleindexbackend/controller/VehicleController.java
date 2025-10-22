package com.tea4e.vehicleindexbackend.controller;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.service.VehicleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    VehicleService service;

    VehicleController(VehicleService service){
        this.service = service;
    }

    @PostMapping
    public void createVehicle(@RequestBody CreateVehicleRequest request){
        service.createVehicle(request);
    }
}
