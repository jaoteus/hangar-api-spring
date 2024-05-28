package com.hangarapi.hangarapi.models;

import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

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

    public Aircraft() {}

    public Aircraft(String aircraftRegistration, String manufacturer, String model, AircraftType aircraftType, AircraftStatus aircraftStatus, EngineType engineType, Double height, Double length, Double weight, Double maximumTakeOffWeight, Double maximumLandingWeight, String operator, Double maximumCargoCapacity, Integer yearBuilt, Integer seatingCapacity, Double range) {
        this.aircraftRegistration = aircraftRegistration;
        this.manufacturer = manufacturer;
        this.model = model;
        this.aircraftType = aircraftType;
        this.aircraftStatus = aircraftStatus;
        this.engineType = engineType;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.maximumTakeOffWeight = maximumTakeOffWeight;
        this.maximumLandingWeight = maximumLandingWeight;
        this.operator = operator;
        this.maximumCargoCapacity = maximumCargoCapacity;
        this.yearBuilt = yearBuilt;
        this.seatingCapacity = seatingCapacity;
        this.range = range;
    }

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public AircraftStatus getAircraftStatus() {
        return aircraftStatus;
    }

    public void setAircraftStatus(AircraftStatus aircraftStatus) {
        this.aircraftStatus = aircraftStatus;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMaximumTakeOffWeight() {
        return maximumTakeOffWeight;
    }

    public void setMaximumTakeOffWeight(Double maximumTakeOffWeight) {
        this.maximumTakeOffWeight = maximumTakeOffWeight;
    }

    public Double getMaximumLandingWeight() {
        return maximumLandingWeight;
    }

    public void setMaximumLandingWeight(Double maximumLandingWeight) {
        this.maximumLandingWeight = maximumLandingWeight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Double getMaximumCargoCapacity() {
        return maximumCargoCapacity;
    }

    public void setMaximumCargoCapacity(Double maximumCargoCapacity) {
        this.maximumCargoCapacity = maximumCargoCapacity;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(aircraftRegistration, aircraft.aircraftRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(aircraftRegistration);
    }
}
