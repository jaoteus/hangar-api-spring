//package com.hangarapi.hangarapi.models;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.List;
//
//
//@Entity
//@Table(name = "tb_hangar")
//public class Hangar implements Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String airportRegistration;
//
//    private List<Aircraft> aircrafts = new ArrayList<Aircraft>();
//
//    public Hangar(){
//    }
//
//    public Hangar(Long id, String airportRegistration){
//        this.id = id;
//        this.airportRegistration = airportRegistration;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getAirportRegistration() {
//        return airportRegistration;
//    }
//
//    public void setAirportRegistration(String airportRegistration) {
//        this.airportRegistration = airportRegistration;
//    }
//
//    public List<Aircraft> getAircrafts() {
//        return aircrafts;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Hangar hangar = (Hangar) o;
//        return Objects.equals(airportRegistration, hangar.airportRegistration);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(airportRegistration);
//    }
//}
