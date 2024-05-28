package com.hangarapi.hangarapi.config;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

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


        Aircraft aircraft2 = new Aircraft(
                "PS-PTS",
                "Boeing",
                "737 Max 8",
                AircraftType.COMERCIAL,
                AircraftStatus.IN_MAINTENANCE,
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

        Aircraft aircraft3 = new Aircraft(
                "PT-MUH",
                "Boeing",
                "777-300ER",
                AircraftType.COMERCIAL,
                AircraftStatus.IN_MAINTENANCE,
                EngineType.TURBOFAN,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Latam Brasil",
                "1000.00",
                "2016",
                "378",
                "21000.00"
        );

        aircraftRepository.saveAll(Arrays.asList(aircraft1, aircraft2, aircraft3));
    }
}
