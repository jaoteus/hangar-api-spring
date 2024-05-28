//package com.hangarapi.hangarapi.services;
//
//import com.hangarapi.hangarapi.models.Aircraft;
//import com.hangarapi.hangarapi.models.Hangar;
//import com.hangarapi.hangarapi.repositories.HangarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class HangarService {
//
//    @Autowired
//    private HangarRepository hangarRepository;
//
//    public List<Aircraft> findAll(){
//
//        return hangarRepository.findAll();
//    }
//
//    public Aircraft findById(Long id) {
//        Optional<Aircraft> optionalAircraft = hangarRepository.findById(id);
//        return optionalAircraft.get();
//    }
//}
