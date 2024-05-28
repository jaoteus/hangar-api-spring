package com.hangarapi.hangarapi.resources;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aircrafts")
public class AircraftResource {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public ResponseEntity<List<Aircraft>> findAll(){
        List<Aircraft> aircraftList = aircraftService.findAll();
        return ResponseEntity.ok().body(aircraftList);
    }

    @GetMapping(value = "/{aircraftRegistration}")
    public ResponseEntity<Aircraft> findById(@PathVariable String aircraftRegistration) {
        Aircraft aircraft = aircraftService.findById(aircraftRegistration);
        return ResponseEntity.ok().body(aircraft);
    }
}
