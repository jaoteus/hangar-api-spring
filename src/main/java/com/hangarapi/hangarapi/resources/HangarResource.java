//package com.hangarapi.hangarapi.resources;
//
//import com.hangarapi.hangarapi.models.Aircraft;
//import com.hangarapi.hangarapi.services.AircraftService;
//import com.hangarapi.hangarapi.services.HangarService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/hangar")
//public class HangarResource {
//
//    @Autowired
//    private HangarService hangarService;
//
//    @GetMapping
//    public ResponseEntity<List<Aircraft>> findAll(){
//        List<Aircraft> aircraftList = hangarService.findAll();
//        return ResponseEntity.ok().body(aircraftList);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Aircraft> findById(@PathVariable Long id) {
//        Aircraft aircraft = hangarService.findById(id);
//        return ResponseEntity.ok().body(aircraft);
//    }
//}
