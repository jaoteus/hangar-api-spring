package com.hangarapi.hangarapi.config;

import com.hangarapi.hangarapi.models.Aircraft;
import com.hangarapi.hangarapi.models.Hangar;
import com.hangarapi.hangarapi.models.enums.AircraftStatus;
import com.hangarapi.hangarapi.models.enums.AircraftType;
import com.hangarapi.hangarapi.models.enums.EngineType;
import com.hangarapi.hangarapi.repositories.AircraftRepository;
import com.hangarapi.hangarapi.repositories.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Configuration
@Component
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private HangarRepository hangarRepository;

    @Override
    public void run(String... args) throws Exception {

        Hangar hangar1 = new Hangar(null,"Hangar no Recife", "SBRF");
        Hangar hangar2 = new Hangar(null,"Hangar Militar da Base Áerea de Anápolis", "SBAN");
        Hangar hangar3 = new Hangar(null, "Hangar em Jacarepagua", "SBJR");

        hangarRepository.saveAll(Arrays.asList(hangar1, hangar2, hangar3));

        // comercial aircrafts
        Aircraft aircraft1 = new Aircraft(
                null,
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
                null,
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
                null,
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

        // military aircrafts
        Aircraft aircraft4 = new Aircraft(
                null,
                "FAB1441",
                "Embraer",
                "T-27M Tucano",
                AircraftType.MILITARY,
                AircraftStatus.ACTIVE,
                EngineType.TURBOPROP,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Força Áerea Brasileira",
                "1000.00",
                "2016",
                "2",
                "2000.00"
        );

        Aircraft aircraft5 = new Aircraft(
                null,
                "FAB2855",
                "Embraer",
                "KC-390",
                AircraftType.MILITARY,
                AircraftStatus.ACTIVE,
                EngineType.TURBOFAN,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Força Áerea Brasileira",
                "1000.00",
                "2016",
                "378",
                "15000.00"
        );

        Aircraft aircraft6 = new Aircraft(
                null,
                "FAB2857",
                "Embraer",
                "KC-390",
                AircraftType.MILITARY,
                AircraftStatus.ACTIVE,
                EngineType.TURBOFAN,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Força Aérea Brasileira",
                "1000.00",
                "2016",
                "378",
                "15000.00"
        );

        // comercial aicraft with turboshaft engine
        Aircraft aircraft7 = new Aircraft(
                null,
                "PR-OHG",
                "Sikorsky",
                "S-92A",
                AircraftType.COMERCIAL,
                AircraftStatus.ACTIVE,
                EngineType.TURBOSHAFT,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Omni Taxi Aereo",
                "230.00",
                "2016",
                "10",
                "1700.00"
        );

        Aircraft aircraft8 = new Aircraft(
                null,
                "PR-LDG",
                "Sikorsky",
                "S-76C-2",
                AircraftType.COMERCIAL,
                AircraftStatus.ACTIVE,
                EngineType.TURBOSHAFT,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "Lider Aviação",
                "257.00",
                "2016",
                "8",
                "1700.00"
        );

        Aircraft aircraft9 = new Aircraft(
                null,
                "PR-BGU",
                "Sikorsky",
                "S-92A",
                AircraftType.COMERCIAL,
                AircraftStatus.ACTIVE,
                EngineType.TURBOSHAFT,
                "0.0",
                "0.0",
                "0.0",
                "1000.00",
                "1000.00",
                "CHC Helicopter",
                "295.00",
                "2016",
                "12",
                "1700.00"
        );

        // saving the aircrafts we added on aircraft repository
        aircraftRepository.saveAll(Arrays.asList(aircraft1, aircraft2, aircraft3));
        aircraftRepository.saveAll(Arrays.asList(aircraft4, aircraft5, aircraft6));
        aircraftRepository.saveAll(Arrays.asList(aircraft7, aircraft8, aircraft9));

        //  adding some comercial aircrafts in hangar1
        hangar1.addAircraft(aircraft1);
        hangar1.addAircraft(aircraft2);
        hangar1.addAircraft(aircraft3);

        // adding some military aircrafts in hangar2
        hangar2.addAircraft(aircraft4);
        hangar2.addAircraft(aircraft5);
        hangar2.addAircraft(aircraft6);

        //  adding some comercial aircrafts with turboshaft engine
        hangar3.addAircraft(aircraft7);
        hangar3.addAircraft(aircraft8);
        hangar3.addAircraft(aircraft9);

        // saving all hangars
        hangarRepository.save(hangar1);
        hangarRepository.save(hangar2);
        hangarRepository.save(hangar3);
    }
}
