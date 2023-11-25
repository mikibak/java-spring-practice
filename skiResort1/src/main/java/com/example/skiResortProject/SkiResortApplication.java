package com.example.skiResortProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication
public class SkiResortApplication {

    /**
     * Application main entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SkiResortApplication.class, args);
    }

    /**
     * @param baseUrl base URL
     * @return configured endpoint for slope module
     */
    @Bean
    public RestTemplate restTemplate(@Value("${rpg.slope.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }

}
