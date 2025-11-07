package com.tea4e.vehicleindexbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GroundVehicle {
    @Id
    private String id;
    private String name;
    private String country;
    @Column(name="battle_rating")
    private Float battleRating;
    @Column(name="`rank`")
    private Integer rank;
    private Integer price;
    @Column(name="`role`")
    private String role;
}
