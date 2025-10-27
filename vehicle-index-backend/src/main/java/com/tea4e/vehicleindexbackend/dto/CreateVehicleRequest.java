package com.tea4e.vehicleindexbackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateVehicleRequest {
    private String id;
    private String name;

}
