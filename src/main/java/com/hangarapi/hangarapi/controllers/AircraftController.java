package com.hangarapi.hangarapi.controllers;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    // dependencies
    @Autowired
    private AircraftService aircraftService;

    // get all
    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        List<Aircraft> aircrafts = aircraftService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(aircrafts);
    }

    // get one
    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Aircraft aircraft = aircraftService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(aircraft);
    }

    // add an aircraft
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Aircraft aircraft){
        aircraftService.insertOne(aircraft);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        aircraftService.updateOne(id, aircraftDetails);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
