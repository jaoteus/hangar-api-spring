package com.hangarapi.hangarapi.services;

import com.hangarapi.hangarapi.exceptions.HangarNotEmptyException;
import com.hangarapi.hangarapi.exceptions.HangarNotFoundException;
import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.repositories.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangarService {

    @Autowired
    private HangarRepository hangarRepository;

    @Autowired
    private AircraftService aircraftService;

    public Hangar findOne(Long id) {
        return hangarRepository.findById(id).orElseThrow(() -> new HangarNotFoundException("Hangar with id " + id + " not found"));
    }

    public List<Hangar> findAll() {
        return hangarRepository.findAll();
    }

    public void insertOne(Hangar hangar) {
        hangarRepository.save(hangar);
    }

    public void updateOne(Long id, Hangar hangar) {
        Hangar hangarToUpdate = findOne(id);
        hangarToUpdate.setName(hangar.getName());
        hangarRepository.save(hangarToUpdate);
    }

    public void deleteOne(Long id) {
        Hangar hangarToDelete = findOne(id);
        if (!hangarToDelete.getAircrafts().isEmpty()) {
            throw new HangarNotEmptyException("The hangar is not empty, try removing all aircrafts before to do this action");
        }
        hangarRepository.delete(hangarToDelete);
    }

    public void insertAnAircraftInHangar(Long aircraftId, Long hangarId) {
        Aircraft aircraftToInsert = aircraftService.findOne(aircraftId);
        Hangar hangar = findOne(hangarId);
        hangar.addAircraft(aircraftToInsert);
        hangarRepository.save(hangar);
    }

    public void deleteAnAircraftInHangar(Long aircraftId, Long hangarId) {
        Aircraft aircraftToDelete = aircraftService.findOne(aircraftId);
        Hangar hangar = findOne(hangarId);
        hangar.removeAircraft(aircraftToDelete);
        hangarRepository.save(hangar);
    }
}
