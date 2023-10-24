package com.example.Project2SpringJPA.initialize;

import com.example.Project2SpringJPA.slope.entity.SkiResort;
import com.example.Project2SpringJPA.slope.entity.Slope;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.Project2SpringJPA.slope.service.api.SlopeService;
import com.example.Project2SpringJPA.slope.service.api.SkiResortService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for slopes operations.
     */
    private final SlopeService slopeService;

    /**
     * Service for ski_resorts operations.
     */
    private final SkiResortService ski_resortService;

    /**
     * @param slopeService  service for managing slopes
     * @param ski_resortService service for managing ski_resorts
     */
    @Autowired
    public InitializeData(
            SlopeService slopeService,
            SkiResortService ski_resortService
    ) {
        this.slopeService = slopeService;
        this.ski_resortService = ski_resortService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
            SkiResort bard = SkiResort.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Bard")
                    .build();

            SkiResort cleric = SkiResort.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Cleric")
                    .build();

            SkiResort warrior = SkiResort.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("Warrior")
                    .build();

            SkiResort rogue = SkiResort.builder()
                    .name("Rogue")
                    .id(UUID.randomUUID())
                    .build();

            ski_resortService.create(bard);
            ski_resortService.create(cleric);
            ski_resortService.create(warrior);
            ski_resortService.create(rogue);

            Slope calvian = Slope.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .name("Calvian")
                    .build();

            Slope uhlbrecht = Slope.builder()
                    .id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                    .name("Uhlbrecht")
                    .build();

            Slope eloise = Slope.builder()
                    .id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                    .name("Eloise")
                    .build();

            Slope zereni = Slope.builder()
                    .id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
                    .name("Zereni")
                    .build();

            slopeService.create(calvian);
            slopeService.create(uhlbrecht);
            slopeService.create(eloise);
            slopeService.create(zereni);
    }
}
