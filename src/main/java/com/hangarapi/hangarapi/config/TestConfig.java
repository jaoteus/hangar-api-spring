package com.hangarapi.hangarapi.config;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public void run(String... args) throws Exception {

        Aircraft aircraft1 = new Aircraft(
                "PS-PTO",
                "Boeing",
                "737-800",
                AircraftType.COMERCIAL,
                AircraftStatus.ACTIVE,
                EngineType.TURBOFAN,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Gol Linhas Aéreas",
                "1000.00",
                "2020",
                "134",
                "4000.00"
                );

        aircraftRepository.save(aircraft1);
    }
}
