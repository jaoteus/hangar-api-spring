package com.hangarapi.hangarapi.controllers;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import com.hangarapi.hangarapi.repositories.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hangars")
public class HangarController {

    // Dependencies
    @Autowired
    private HangarRepository hangarRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    public List<Hangar> getAllHangars() {
        return hangarRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hangar> getHangarById(@PathVariable Long id) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        return hangar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hangar createHangar(@RequestBody Hangar hangar) {
        return hangarRepository.save(hangar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hangar> updateHangar(@PathVariable Long id, @RequestBody Hangar hangarDetails) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        if (hangar.isPresent()) {
            Hangar updatedHangar = hangar.get();
            updatedHangar.setAirportRegistration(hangarDetails.getAirportRegistration());
            return ResponseEntity.ok(hangarRepository.save(updatedHangar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHangar(@PathVariable Long id) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        if (hangar.isPresent()) {
            hangarRepository.delete(hangar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Aircraft Endpoints

    @GetMapping("/{id}/aircrafts")
    public ResponseEntity<List<Aircraft>> getAircraftsByHangarId(@PathVariable Long id) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        return hangar.map(h -> ResponseEntity.ok(h.getAircrafts())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/aircrafts")
    public ResponseEntity<Hangar> addAircraftToHangar(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        if (aircraftRepository.findByAircraftRegistration(aircraft.getAircraftRegistration()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Hangar hangar = hangarRepository.findById(id).orElseThrow(() -> new RuntimeException("Hangar not found"));
        hangar.getAircrafts().add(aircraft);
        return ResponseEntity.ok(hangarRepository.save(hangar));
    }

    @PutMapping("/aircrafts/{aircraftId}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long aircraftId, @RequestBody Aircraft aircraftDetails) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
        if (aircraft.isPresent()) {
            Aircraft updatedAircraft = aircraft.get();
            updatedAircraft.setAircraftStatus(aircraftDetails.getAircraftStatus());
            updatedAircraft.setOperator(aircraftDetails.getOperator());
            updatedAircraft.setSeatingCapacity(aircraftDetails.getSeatingCapacity());
            updatedAircraft.setModel(aircraftDetails.getModel());
            updatedAircraft.setAircraftRegistration(aircraftDetails.getAircraftRegistration());

            if (aircraftRepository.findByAircraftRegistration(updatedAircraft.getAircraftRegistration()).isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(aircraftRepository.save(updatedAircraft));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/aircrafts/{aircraftId}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long aircraftId) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
        if (aircraft.isPresent()) {
            aircraftRepository.delete(aircraft.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
