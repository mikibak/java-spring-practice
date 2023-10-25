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

        slopeService.create(Slope.builder().id(UUID.fromString("7af3f76d-3724-4f2e-9ea2-3d63ff4e2395")).name("Gressoney").steepness(9).skiResort(Monterosa).build());
        slopeService.create(Slope.builder().id(UUID.fromString("b92810b7-1e76-4f32-975f-c10d5cc3e5a7")).name("Champorcher").steepness(12).skiResort(Monterosa).build());
        slopeService.create(Slope.builder().id(UUID.fromString("8f0f5e26-5a7c-46cc-8c38-8f791d6b5d1e")).name("Balma").steepness(16).skiResort(Monterosa).build());

        slopeService.create(Slope.builder().id(UUID.fromString("9ec95313-39e9-4a20-9465-f4aa2ea4c267")).name("Le Trat").steepness(1).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.fromString("c26a4239-e607-4746-90cf-23c2f8d22e1e")).name("Baby").steepness(12).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.fromString("60c3d3ec-8f1a-4aa0-b2e2-241eb824c6b3")).name("La Combe").steepness(21).skiResort(SappeyEnChartreuse).build());
        slopeService.create(Slope.builder().id(UUID.fromString("4c89d6aa-b67f-47a0-8ef4-b5d2d8b7e146")).name("La Palle").steepness(40).skiResort(SappeyEnChartreuse).build());

        slopeService.create(Slope.builder().id(UUID.fromString("59c1783d-0463-4db6-9811-9437f8813e34")).name("Kotlinka").steepness(12).skiResort(Wiezyca).build());
        slopeService.create(Slope.builder().id(UUID.fromString("0f103a6e-2e34-4c7c-8fe4-86c6a5d9ebf5")).name("Misiowa Górka").steepness(2).skiResort(Wiezyca).build());
        slopeService.create(Slope.builder().id(UUID.fromString("35f7ce0b-6b2a-4bb2-9f5c-28de859b6df1")).name("Koszałkowy Wierch").steepness(30).skiResort(Wiezyca).build());
    }
}
