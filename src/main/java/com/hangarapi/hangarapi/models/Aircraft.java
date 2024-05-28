package com.hangarapi.hangarapi.models;

import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_aircraft")
public class Aircraft implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // informações técnicas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aircraftRegistration;
    private String manufacturer;
    private String model;
    private AircraftType aircraftType;
    private AircraftStatus aircraftStatus;
    private EngineType engineType;

    // caracteristicas físicas básicas
    private String length;
    private String height;
    private String weight;
    private String maximumTakeOffWeight;
    private String maximumLandingWeight;
    private String operator;
    private String yearBuilt;
    private String maximumCargoCapacity;
    private String seatingCapacity;
    private String range;

//    private Hangar hangar;

    public Aircraft() {}

    public Aircraft(Long id, String aircraftRegistration, String manufacturer, String model, AircraftType aircraftType, AircraftStatus aircraftStatus, EngineType engineType, String height, String length, String weight, String maximumTakeOffWeight, String maximumLandingWeight, String operator, String maximumCargoCapacity, String yearBuilt, String seatingCapacity, String range) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaximumTakeOffWeight() {
        return maximumTakeOffWeight;
    }

    public void setMaximumTakeOffWeight(String maximumTakeOffWeight) {
        this.maximumTakeOffWeight = maximumTakeOffWeight;
    }

    public String getMaximumLandingWeight() {
        return maximumLandingWeight;
    }

    public void setMaximumLandingWeight(String maximumLandingWeight) {
        this.maximumLandingWeight = maximumLandingWeight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getMaximumCargoCapacity() {
        return maximumCargoCapacity;
    }

    public void setMaximumCargoCapacity(String maximumCargoCapacity) {
        this.maximumCargoCapacity = maximumCargoCapacity;
    }

    public String getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(String seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
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
