package com.example.skiResortProject.skiResort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skiResortProject.skiResort.entity.SkiResort;
import com.example.skiResortProject.skiResort.event.repository.api.SkiResortEventRepository;
import com.example.skiResortProject.skiResort.repository.api.SkiResortRepository;
import com.example.skiResortProject.skiResort.service.api.SkiResortService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope's skiResort entity.
 */
@Service
public class SkiResortDefaultService implements SkiResortService {

    /**
     * Repository for skiResort entity.
     */
    private final SkiResortRepository repository;

    /**
     * Repository for sending events about skiResorts management.
     */
    private final SkiResortEventRepository eventRepository;

    /**
     * @param repository      repository for skiResort entity
     * @param eventRepository repository for sending events about skiResorts management
     */
    @Autowired
    public SkiResortDefaultService(SkiResortRepository repository, SkiResortEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<SkiResort> findAll() {
        return repository.findAll();
    }

    /**
     * @param id id of the skiResort
     * @return container with skiResort entity
     */
    @Override
    public Optional<SkiResort> find(UUID id) {
        return repository.findById(id);
    }

    /**
     * Stores new skiResort in the data store.
     *
     * @param skiResort new skiResort to be saved
     */
    @Override
    public void create(SkiResort skiResort) {
        repository.save(skiResort);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
