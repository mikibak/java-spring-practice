package com.example.SkiResortProject.skiResort.event.repository.api;

import java.util.UUID;

/**
 * Repository for sending events about skiResort.
 */
public interface SkiResortEventRepository {

    /**
     * Delete skiResort.
     *
     * @param id skiResort's id
     */
    void delete(UUID id);

}
