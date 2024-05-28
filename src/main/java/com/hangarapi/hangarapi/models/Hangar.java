package com.hangarapi.hangarapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;


@Entity
@Table(name = "tb_hangar")
public class Hangar implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String airportRegistration;

    @JsonIgnore
    @OneToMany(mappedBy = "hangar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aircraft> aircrafts = new ArrayList<>();

    public Hangar(){
    }

    public Hangar(Long id, String name, String airportRegistration){
        this.id = id;
        this.airportRegistration = airportRegistration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportRegistration() {
        return airportRegistration;
    }

    public void setAirportRegistration(String airportRegistration) {
        this.airportRegistration = airportRegistration;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        aircraft.setHangar(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft);
        aircraft.setHangar(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hangar hangar = (Hangar) o;
        return Objects.equals(airportRegistration, hangar.airportRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(airportRegistration);
    }
}
