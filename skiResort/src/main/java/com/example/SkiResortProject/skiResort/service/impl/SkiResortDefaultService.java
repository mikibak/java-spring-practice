package com.example.SkiResortProject.skiResort.service.impl;

import com.example.SkiResortProject.skiResort.entity.SkiResort;
import com.example.SkiResortProject.skiResort.event.repository.api.SkiResortEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SkiResortProject.skiResort.repository.api.SkiResortRepository;
import com.example.SkiResortProject.skiResort.service.api.SkiResortService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope's ski_resort entity.
 */
@Service
public class SkiResortDefaultService implements SkiResortService {

    /**
     * Repository for ski_resort entity.
     */
    private final SkiResortRepository repository;

    private final SkiResortEventRepository eventRepository;

    /**
     * @param repository      repository for ski_resort entity
     * @param eventRepository
     */
    @Autowired
    public SkiResortDefaultService(SkiResortRepository repository, SkiResortEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    /**
     * @param id id of the ski_resort
     * @return container with ski_resort entity
     */
    @Override
    public Optional<SkiResort> find(UUID id) {
        return repository.findById(id);
    }

    /**
     * Stores new ski_resort in the data store.
     *
     * @param ski_resort new ski_resort to be saved
     */
    @Override
    public void create(SkiResort ski_resort) {
        repository.save(ski_resort);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

    @Override
    public List<SkiResort> findAll() {
        return repository.findAll();
    }

}
