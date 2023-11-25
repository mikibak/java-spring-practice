package com.example.SkiResortProject.skiResort.initialize;

import com.example.SkiResortProject.skiResort.entity.SkiResort;
import com.example.SkiResortProject.skiResort.service.api.SkiResortService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDate;
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
     * Service for ski_resorts operations.
     */
    private final SkiResortService ski_resortService;

    /**
     * @param ski_resortService service for managing ski_resorts
     */
    @Autowired
    public InitializeData(
            SkiResortService ski_resortService
    ) {
        this.ski_resortService = ski_resortService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SkiResort Monterosa = SkiResort
                .builder()
                .id(UUID.randomUUID())
                .name("Monterosa")
                .visitors(10000)
                .build();
        SkiResort SappeyEnChartreuse = SkiResort
                .builder()
                .id(UUID.randomUUID())
                .name("Sappey-en-Chartreuse")
                .visitors(1700)
                .build();
        SkiResort Wiezyca = SkiResort
                .builder()
                .id(UUID.randomUUID())
                .name("Wieżyca")
                .visitors(150)
                .build();

        ski_resortService.create(Monterosa);
        ski_resortService.create(SappeyEnChartreuse);
        ski_resortService.create(Wiezyca);
    }
}
