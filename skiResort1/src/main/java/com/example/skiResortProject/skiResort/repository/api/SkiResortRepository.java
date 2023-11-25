package com.example.skiResortProject.skiResort.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.skiResortProject.skiResort.entity.SkiResort;

import java.util.UUID;

/**
 * Repository for skiResort entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, UUID> {

}
