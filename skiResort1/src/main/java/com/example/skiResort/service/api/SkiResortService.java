package com.example.skiResort.service.api;

import com.example.skiResort.entity.SkiResort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope's skiResort entity.
 */
public interface SkiResortService {


    /**
     * @param id id of the skiResort
     * @return container with skiResort entity
     */
    Optional<SkiResort> find(UUID id);

    /**
     * Stores new skiResort in the data store.
     *
     * @param skiResort new skiResort to be saved
     */
    void create(SkiResort skiResort);

    /**
     * @return all available skiResorts
     */
    List<SkiResort> findAll();

    /**
     * Deletes existing skiResort.
     *
     * @param id existing skiResort's id to be deleted
     */
    void delete(UUID id);

}
