package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
