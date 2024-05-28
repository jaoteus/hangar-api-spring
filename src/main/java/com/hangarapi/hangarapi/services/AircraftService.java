package com.hangarapi.hangarapi.services;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircraft> findAll(){
        return aircraftRepository.findAll();
    }

    public Aircraft findById(String aircraftRegistration) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraftRegistration);
        return optionalAircraft.get();
    }
}
