package com.hangarapi.hangarapi.models;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb_hangar")
public class Hangar implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "airport_registration")
    private String airportRegistration;

    @OneToMany(mappedBy = "hangar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aircraft> aircrafts = new ArrayList<>();

    public Hangar(){
    }

    public Hangar(Long id, String name, String airportRegistration){
        this.id = id;
        this.name = name;
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
