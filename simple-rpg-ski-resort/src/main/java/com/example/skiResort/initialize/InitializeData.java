package com.example.skiResort.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.skiResort.entity.SkiResort;
import com.example.skiResort.service.api.SkiResortService;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for skiResorts operations.
     */
    private final SkiResortService skiResortService;

    /**
     * @param skiResortService service for managing skiResorts
     */
    @Autowired
    public InitializeData(SkiResortService skiResortService) {
        this.skiResortService = skiResortService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SkiResort Monterosa = SkiResort
                .builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("Monterosa")
                .visitors(10000)
                .build();
        SkiResort SappeyEnChartreuse = SkiResort
                .builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Sappey-en-Chartreuse")
                .visitors(1700)
                .build();
        SkiResort Wiezyca = SkiResort
                .builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Wieżyca")
                .visitors(150)
                .build();

        skiResortService.create(Monterosa);
        skiResortService.create(SappeyEnChartreuse);
        skiResortService.create(Wiezyca);
    }

}
