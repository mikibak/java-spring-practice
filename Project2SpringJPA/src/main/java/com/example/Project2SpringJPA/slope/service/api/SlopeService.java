package com.example.Project2SpringJPA.slope.service.api;

import com.example.Project2SpringJPA.slope.entity.SkiResort;
import com.example.Project2SpringJPA.slope.entity.Slope;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope entity.
 */

public interface SlopeService {

    /**
     * Finds single slope.
     *
     * @param id slope's id
     * @return container with slope
     */
    Optional<Slope> find(UUID id);

    /**
     * @return all available slopes
     */
    List<Slope> findAll();

    /**
     * Creates new slope.
     *
     * @param slope new slope
     */
    void create(Slope slope);

    /**
     * Updates existing slope.
     *
     * @param slope slope to be updated
     */
    void update(Slope slope);

    /**
     * Deletes existing slope.
     *
     * @param id existing slope's id to be deleted
     */
    void delete(UUID id);

    /**
     * @param skiResortId ski_resort id
     * @return list of slopes if ski resort exists
     */
    Optional<List<Slope>> findAllBySkiResort(UUID skiResortId);

}
