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
                .id(UUID.randomUUID())
                .name("Monterosa")
                .visitors(10000)
                .slopes(new ArrayList<>())
                .build();
        SkiResort SappeyEnChartreuse = SkiResort
                .builder()
                .id(UUID.randomUUID())
                .name("Sappey-en-Chartreuse")
                .slopes(new ArrayList<>())
                .visitors(1700)
                .build();
        SkiResort Wiezyca = SkiResort
                .builder()
                .id(UUID.randomUUID())
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
