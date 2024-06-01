package com.hangarapi.hangarapi.services;

import com.hangarapi.hangarapi.exceptions.AircraftNotFoundException;
import com.hangarapi.hangarapi.exceptions.IntegrityViolationException;
import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    // we will use this method to search an aircraft by id
    public Aircraft findOne(Long id) {
        return aircraftRepository.findById(id).orElseThrow(() -> new AircraftNotFoundException("Aircraft with id " + id + " not found"));
    }

    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    public void insertOne(Aircraft aircraft) {
        try {
            aircraftRepository.save(aircraft);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    public void updateOne(Long id, Aircraft aircraft) {
        Aircraft aircraftToUpdate = findOne(id);
        aircraftToUpdate.setAircraftStatus(aircraft.getAircraftStatus());
        aircraftToUpdate.setOperator(aircraft.getOperator());
        aircraftToUpdate.setSeatingCapacity(aircraft.getSeatingCapacity());
        aircraftToUpdate.setAircraftType(aircraft.getAircraftType());
        aircraftToUpdate.setAircraftRegistration(aircraft.getAircraftRegistration());

        try {
            aircraftRepository.save(aircraftToUpdate);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
    }

    public void deleteOne(Long id) {
        Aircraft aircraftToDelete = findOne(id);
        try {
            aircraftRepository.delete(aircraftToDelete);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
