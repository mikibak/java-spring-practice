package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${rpg.slope.url}") String slopeUrl,
            @Value("${rpg.skiResort.url}") String skiResortUrl,
            @Value("${rpg.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("skiResorts", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/skiResorts/{uuid}",
                                "/api/skiResorts"
                        )
                        .uri(skiResortUrl)
                )
                .route("slopes", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/slopes",
                                "/api/slopes/**",
                                "/api/skiResorts/{uuid}/slopes",
                                "/api/skiResorts/{uuid}/slopes/**"
                        )
                        .uri(slopeUrl)
                )
                .build();
    }
}
