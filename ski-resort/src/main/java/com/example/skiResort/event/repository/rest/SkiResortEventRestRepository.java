package com.example.skiResort.event.repository.rest;

import com.example.skiResort.event.repository.api.SkiResortEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class SkiResortEventRestRepository implements SkiResortEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public SkiResortEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/skiResorts/{id}", id);
    }

}
