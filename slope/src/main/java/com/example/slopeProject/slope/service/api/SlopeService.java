package com.example.slopeProject.slope.service.api;

import com.example.slopeProject.slope.dto.PatchSlopeRequest;
import com.example.slopeProject.skiResort.entity.SkiResort;
import com.example.slopeProject.slope.entity.Slope;

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
     */

    void update(UUID id, PatchSlopeRequest request);

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
