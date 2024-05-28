package com.hangarapi.hangarapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hangarapi.hangarapi.models.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {
}
