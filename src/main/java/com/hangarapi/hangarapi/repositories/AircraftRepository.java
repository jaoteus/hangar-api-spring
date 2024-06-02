package com.hangarapi.hangarapi.repositories;

import com.hangarapi.hangarapi.models.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    Aircraft findByAircraftRegistration(String aircraftRegistration);
}
