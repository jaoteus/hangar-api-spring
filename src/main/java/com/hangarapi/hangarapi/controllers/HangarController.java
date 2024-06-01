package com.hangarapi.hangarapi.controllers;

import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.services.HangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/hangars")
public class HangarController {

    // Dependency
    @Autowired
    private HangarService hangarService;

    // get all hangars
    @GetMapping
    public ResponseEntity<List<Hangar>> getAllHangars() {
        List<Hangar> hangarList = hangarService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(hangarList);
    }

    // get one hangar
    @GetMapping("/{id}")
    public ResponseEntity<Hangar> getHangarById(@PathVariable Long id) {
        Hangar hangar = hangarService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(hangar);
    }

    // create a hangar
    @PostMapping
    public ResponseEntity<Hangar> createHangar(@RequestBody Hangar hangar) {
        hangarService.insertOne(hangar);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update all hangar fields
    @PutMapping("/{id}")
    public ResponseEntity<Hangar> updateAllHangarData(
            @PathVariable Long id,
            @RequestBody Hangar hangarDetails) {
        hangarService.updateOne(id, hangarDetails);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // delete a hangar by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHangar(@PathVariable Long id) {
        hangarService.deleteOne(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // add an aircraft (by its id) to a hangar (by its id)
    @PostMapping("/{hangarId}/aircrafts/{aircraftId}")
    public ResponseEntity<Void> insertAnAircraftInHangar(
            @PathVariable Long hangarId,
            @PathVariable Long aircraftId) {
        hangarService.insertAnAircraftInHangar(aircraftId, hangarId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // remove an aircraft (by its id) from a hangar (by its id)
    @DeleteMapping("/{hangarId}/aircrafts/{aircraftId}")
    public ResponseEntity<Void> removeAnAircraftInHangar(
            @PathVariable Long hangarId,
            @PathVariable Long aircraftId) {
        hangarService.deleteAnAircraftInHangar(aircraftId, hangarId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
