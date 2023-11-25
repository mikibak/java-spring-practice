package com.example.skiResortProject.skiResort.event.repository.api;

import java.util.UUID;

/**
 * Repository for sending events about skiResorts.
 */
public interface SkiResortEventRepository {

    /**
     * Delete skiResort.
     *
     * @param id skiResort's id
     */
    void delete(UUID id);

}
