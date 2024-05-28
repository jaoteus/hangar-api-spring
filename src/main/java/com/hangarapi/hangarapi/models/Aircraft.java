package com.hangarapi.hangarapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aircraft")
public class Aircraft {
    
    @Id
    private String aircraftRegistration;
    
}
