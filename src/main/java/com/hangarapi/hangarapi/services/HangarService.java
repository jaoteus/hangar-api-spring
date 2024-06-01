package com.hangarapi.hangarapi.services;

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

    // we will use this method to search an aircraft by id
    public Hangar findOne(Long id) {
        return hangarRepository.findById(id).orElseThrow(() -> new HangarNotFoundException("Hangar with id " + id + " not found"));
    }

    public List<Hangar> findAll() {
        return hangarRepository.findAll();
    }

    public void insertOne(Hangar hangar) {
        try {
            hangarRepository.save(hangar);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void updateOne(Long id, Hangar hangar) {
        Hangar hangarToUpdate = findOne(id);
        hangarToUpdate.setName(hangar.getName());

        try {
            hangarRepository.save(hangarToUpdate);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void deleteOne(Long id) {
        Hangar hangarToDelete = findOne(id);
        try {
            hangarRepository.delete(hangarToDelete);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
