package com.tea4e.vehicleindexbackend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateVehicleBatchRequest {
    List<VehicleDTO> data;
}
