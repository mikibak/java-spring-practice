package com.example.slopeProject.slope.initialize;

import com.example.slopeProject.skiResort.entity.SkiResort;
import com.example.slopeProject.skiResort.service.api.SkiResortService;
import com.example.slopeProject.slope.entity.Slope;
import com.example.slopeProject.slope.service.api.SlopeService;
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
        SkiResort Monterosa = SkiResort
                .builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("Monterosa")
                .visitors(10000)
                .slopes(new ArrayList<>())
                .build();
        SkiResort SappeyEnChartreuse = SkiResort
                .builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Sappey-en-Chartreuse")
                .slopes(new ArrayList<>())
                .visitors(1700)
                .build();
        SkiResort Wiezyca = SkiResort
                .builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Wieżyca")
                .visitors(150)
                .slopes(new ArrayList<>())
                .build();

        ski_resortService.create(Monterosa);
        ski_resortService.create(SappeyEnChartreuse);
        ski_resortService.create(Wiezyca);

        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Gressoney").steepness(9).skiResort(Monterosa).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Champorcher").steepness(12).skiResort(Monterosa).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Balma").steepness(16).skiResort(Monterosa).build());

        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Le Trat").steepness(1).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Baby").steepness(12).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("La Combe").steepness(21).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("La Palle").steepness(40).skiResort(SappeyEnChartreuse).build());

        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Kotlinka").steepness(12).skiResort(Wiezyca).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Misiowa Górka").steepness(2).skiResort(Wiezyca).build());
        slopeService.create(Slope.builder().id(UUID.randomUUID()).name("Koszałkowy Wierch").steepness(30).skiResort(Wiezyca).build());
    }
}
