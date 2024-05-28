package com.hangarapi.hangarapi.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_hangar")
public class Hangar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // PROVISORIOS
    private String address;

    public Hangar(){
    }

    public Hangar(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hangar hangar = (Hangar) o;
        return Objects.equals(id, hangar.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
