package com.hangarapi.hangarapi.controllers;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    // dependencies
    @Autowired
    private AircraftRepository aircraftRepository;

    // get all
    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        return ResponseEntity.ok().body(aircraftRepository.findAll());
    }

    // get one
    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);
        return optionalAircraft.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // delete one
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (aircraft.isPresent()) {
            aircraftRepository.delete(aircraft.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update all fields
    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateALlFields(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (aircraft.isPresent()) {
            Aircraft updatedAircraft = aircraft.get();
            updatedAircraft.setAircraftStatus(aircraftDetails.getAircraftStatus());
            updatedAircraft.setOperator(aircraftDetails.getOperator());
            updatedAircraft.setSeatingCapacity(aircraftDetails.getSeatingCapacity());
            updatedAircraft.setModel(aircraftDetails.getModel());
            updatedAircraft.setAircraftRegistration(aircraftDetails.getAircraftRegistration());

//            if (aircraftRepository.findByAircraftRegistration(updatedAircraft.getAircraftRegistration()).isPresent()) {
//                return ResponseEntity.badRequest().body(null);
//            }
            return ResponseEntity.ok(aircraftRepository.save(updatedAircraft));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update some fields
    @PatchMapping("/{id}")
    public ResponseEntity<Aircraft> updateSomeFields(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        Optional<Aircraft> aircraft = aircraftRepository.findById(id);
        if (aircraft.isPresent()) {
            Aircraft updatedAircraft = aircraft.get();
            updatedAircraft.setAircraftStatus(aircraftDetails.getAircraftStatus());
            updatedAircraft.setOperator(aircraftDetails.getOperator());
            updatedAircraft.setSeatingCapacity(aircraftDetails.getSeatingCapacity());
            updatedAircraft.setModel(aircraftDetails.getModel());
            updatedAircraft.setAircraftRegistration(aircraftDetails.getAircraftRegistration());

//            if (aircraftRepository.findByAircraftRegistration(updatedAircraft.getAircraftRegistration()).isPresent()) {
//                return ResponseEntity.badRequest().body(null);
//            }
            return ResponseEntity.ok(aircraftRepository.save(updatedAircraft));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // create an aircraft
    @PostMapping
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft) {
//        if (aircraftRepository.findByAircraftRegistration(aircraft.getAircraftRegistration()).isPresent()) {
//            return ResponseEntity.badRequest().body(null);
//        }
        aircraftRepository.save(aircraft);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aircraft.getId()).toUri();
        return ResponseEntity.created(uri).body(aircraft);
    }
}
