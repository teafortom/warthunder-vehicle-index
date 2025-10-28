package com.tea4e.vehicleindexbackend.controller;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleBatchRequest;
import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    VehicleService service;

    VehicleController(VehicleService service){
        this.service = service;
    }

    @PutMapping("/{id}")
    public void createVehicle(@PathVariable String id, @RequestBody CreateVehicleRequest request){
        service.createVehicle(id, request);
    }

    @PostMapping("/batch")
    public void createBatch(@RequestBody CreateVehicleBatchRequest batchRequest) {
//        System.out.print(batchRequest);
        // Optional: deduplicate by URL
        service.createVehicleBatch(batchRequest);
    }

}
