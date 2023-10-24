package com.example.Project2SpringJPA.slope.service.impl;

import com.example.Project2SpringJPA.slope.entity.Slope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Project2SpringJPA.slope.repository.api.SlopeRepository;
import com.example.Project2SpringJPA.slope.repository.api.SkiResortRepository;
import com.example.Project2SpringJPA.slope.service.api.SlopeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding slope entity.
 */
@Service
public class SlopeDefaultService implements SlopeService {

    /**
     * Repository for slope entity.
     */
    private final SlopeRepository repository;

    /**
     * Repository for ski_resort entity.
     */
    private final SkiResortRepository ski_resortRepository;


    /**
     * @param repository           repository for slope entity
     * @param ski_resortRepository repository for ski_resort entity
     */
    @Autowired
    public SlopeDefaultService(
            SlopeRepository repository,
            SkiResortRepository ski_resortRepository
    ) {
        this.repository = repository;
        this.ski_resortRepository = ski_resortRepository;
    }

    @Override
    public Optional<Slope> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Slope> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Slope>> findAllBySkiResort(UUID ski_resortId) {
        return ski_resortRepository.findById(ski_resortId)
                .map(repository::findAllBySkiResort);
    }

    @Override
    public void create(Slope slope) {
        repository.save(slope);
    }

    @Override
    public void update(Slope slope) {
        repository.save(slope);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
