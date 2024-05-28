package com.hangarapi.hangarapi.repository;

import com.hangarapi.hangarapi.model.*; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangarRepository extends JpaRepository<Aircraft, Long> {
}
