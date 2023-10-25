package com.example.Project2SpringJPA.slope.service.api;

import com.example.Project2SpringJPA.slope.entity.SkiResort;
import com.example.Project2SpringJPA.slope.entity.Slope;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope's ski_resort entity.
 */
public interface SkiResortService {


    /**
     * @param id id of the ski_resort
     * @return container with ski_resort entity
     */
    Optional<SkiResort> find(UUID id);

    /**
     * Stores new ski_resort in the data store.
     *
     * @param ski_resort new ski_resort to be saved
     */
    void create(SkiResort ski_resort);

    /**
     * @return all available slopes
     */
    List<SkiResort> findAll();
}
