package com.example.slopeProject.slope.repository.api;

import com.example.slopeProject.skiResort.entity.SkiResort;
import com.example.slopeProject.slope.entity.Slope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SlopeRepository extends JpaRepository<Slope, UUID> {

    /**
     * Seeks for single user's slope.
     *
     * @param id   slope's id
     * @return container (can be empty) with slope
     */
    Optional<Slope> findById(UUID id);

    /**
     * Seeks for all user's slopes.
     *
     * @param ski_resort slopes' owner
     * @return list (can be empty) of user's slopes
     */

    List<Slope> findAllBySkiResort(SkiResort ski_resort);

}
