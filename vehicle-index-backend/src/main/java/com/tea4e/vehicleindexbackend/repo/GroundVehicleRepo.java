package com.tea4e.vehicleindexbackend.repo;

import com.tea4e.vehicleindexbackend.entity.GroundVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroundVehicleRepo extends JpaRepository<GroundVehicle, Integer> {
}
