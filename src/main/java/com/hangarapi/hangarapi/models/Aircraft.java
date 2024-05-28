package com.hangarapi.hangarapi.models;

import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aircraft")
public class Aircraft {

    // informações técnicas
    @Id
    private String aircraftRegistration;
    private String manufacturer;
    private String model;
    private AircraftType aircraftType;
    private AircraftStatus aircraftStatus;
    private EngineType engineType;

    // caracteristicas físicas básicas
    private Double length;
    private Double height;
    private Double weight;
    private Double maximumTakeOffWeight;
    private Double maximumLandingWeight;
    private String operator;
    private Integer yearBuilt;
    private Double maximumCargoCapacity;
    private Integer seatingCapacity;
    private Double range;


}
