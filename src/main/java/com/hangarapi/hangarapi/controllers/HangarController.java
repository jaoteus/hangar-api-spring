package com.hangarapi.hangarapi.controllers;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import com.hangarapi.hangarapi.repositories.HangarRepository;
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
@RequestMapping("/hangars")
public class HangarController {

    // Dependencies
    @Autowired
    private HangarRepository hangarRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    public ResponseEntity<List<Hangar>> getAllHangars() {
        return ResponseEntity.ok().body(hangarRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hangar> getHangarById(@PathVariable Long id) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        return hangar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hangar> createHangar(@RequestBody Hangar hangar) {
        hangarRepository.save(hangar);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hangar.getId()).toUri();
        return ResponseEntity.created(uri).body(hangar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hangar> updateAllHangarData(@PathVariable Long id, @RequestBody Hangar hangarDetails) {
        Optional<Hangar> hangar = hangarRepository.findById(id);
        if (hangar.isPresent()) {
            Hangar updatedHangar = hangar.get();
            updatedHangar.setAirportRegistration(hangarDetails.getAirportRegistration());
            return ResponseEntity.ok(hangarRepository.save(updatedHangar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Hangar> updateSomeHangarData(@PathVariable Long id, @RequestBody Hangar hangarDetails) {
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

    @PostMapping("/{hangarId}/aircrafts/{aircraftId}")
    public ResponseEntity<Aircraft> addAircraftInHangar(@PathVariable Long hangarId, @PathVariable Long aircraftId) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraftId);
        Optional<Hangar> optionalHangar = hangarRepository.findById(hangarId);
        if (optionalAircraft.isPresent() && optionalHangar.isPresent()) {
            Hangar hangar = optionalHangar.get();
            Aircraft aircraft = optionalAircraft.get();
            hangar.addAircraft(aircraft);
            hangarRepository.save(hangar);
            return ResponseEntity.ok().body(aircraft);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{hangarId}/aircrafts/{aircraftId}")
    public ResponseEntity<Aircraft> removeAircraftInHangar(@PathVariable Long hangarId, @PathVariable Long aircraftId) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraftId);
        Optional<Hangar> optionalHangar = hangarRepository.findById(hangarId);
        if (optionalAircraft.isPresent() && optionalHangar.isPresent()) {
            Hangar hangar = optionalHangar.get();
            Aircraft aircraft = optionalAircraft.get();
            hangar.removeAircraft(aircraft);
            hangarRepository.save(hangar);
            return ResponseEntity.ok().body(aircraft);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
