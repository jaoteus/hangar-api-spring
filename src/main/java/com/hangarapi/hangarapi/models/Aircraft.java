package com.hangarapi.hangarapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_aircraft")
public class Aircraft implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // technical informations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, name = "aircraft_registration", nullable = false)
    private String aircraftRegistration;
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "aircraft_type")
    private AircraftType aircraftType;
    @Column(name = "aircraft_status")
    private AircraftStatus aircraftStatus;
    @Column(name = "engine_type", nullable = false)
    private EngineType engineType;

    // basic physical characteristics
    @Column(name = "length", nullable = false)
    private String length;
    @Column(name = "height", nullable = false)
    private String height;
    @Column(name = "weight", nullable = false)
    private String weight;
    @Column(name = "maximum_takeoff_weight")
    private String maximumTakeOffWeight;
    @Column(name = "maximum_landing_weight")
    private String maximumLandingWeight;
    @Column(name = "operator", nullable = false)
    private String operator;
    @Column(name = "year_built")
    private String yearBuilt;
    @Column(name = "maximum_cargo_capacity")
    private String maximumCargoCapacity;
    @Column(name = "seating_capacity")
    private String seatingCapacity;
    @Column(name = "range")
    private String range;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "hangar_id")
    private Hangar hangar;

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

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(id, aircraft.id) && Objects.equals(aircraftRegistration, aircraft.aircraftRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aircraftRegistration);
    }
}
