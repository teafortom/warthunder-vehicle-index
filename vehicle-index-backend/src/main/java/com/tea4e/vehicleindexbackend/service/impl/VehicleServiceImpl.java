package com.tea4e.vehicleindexbackend.service.impl;

import com.tea4e.vehicleindexbackend.dto.CreateVehicleBatchRequest;
import com.tea4e.vehicleindexbackend.dto.CreateVehicleRequest;
import com.tea4e.vehicleindexbackend.dto.VehicleDTO;
import com.tea4e.vehicleindexbackend.entity.GroundVehicle;
import com.tea4e.vehicleindexbackend.repo.GroundVehicleRepo;
import com.tea4e.vehicleindexbackend.service.VehicleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    GroundVehicleRepo groundRepo;

    @Autowired
    public void setGroundRepo(GroundVehicleRepo groundRepo) {
        this.groundRepo = groundRepo;
    }

    @Override
    public void createVehicle(String id, CreateVehicleRequest request) {

        GroundVehicle entity = request2Entity(id, request);
        GroundVehicle result = groundRepo.save(entity);

    }

    @Override
    public void createVehicleBatch(CreateVehicleBatchRequest batchRequest) {
        batchRequest.getData().stream().forEach(System.out::println);
        List<GroundVehicle> entites = batchRequest.getData().stream().map(this::dto2Entity).toList();
        groundRepo.saveAll(entites);
    }

    private GroundVehicle request2Entity(String id, CreateVehicleRequest request){
        return GroundVehicle.builder()
                .id(id)
                .name(request.getName())
                .build();
    }

    private GroundVehicle dto2Entity(VehicleDTO dto){
        return GroundVehicle.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(dto.getCountry())
                .battleRating(dto.getBattleRating())
                .price(dto.getPrice())
                .rank(dto.getRank())
                .role(dto.getRole())
                .build();
    }

}
