package com.tea4e.vehicleindexbackend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String id;
    private String name;
    private String country;
    @JsonProperty("battle_rating")
    private float battleRating;
    private int rank;
    private int price;
}
