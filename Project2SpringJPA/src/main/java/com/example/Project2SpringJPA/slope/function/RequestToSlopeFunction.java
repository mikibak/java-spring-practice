package com.example.Project2SpringJPA.slope.function;

import org.springframework.stereotype.Component;
import com.example.Project2SpringJPA.slope.dto.PutSlopeRequest;
import com.example.Project2SpringJPA.slope.entity.Slope;
import com.example.Project2SpringJPA.slope.entity.SkiResort;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Converts {@link PutSlopeRequest} to {@link Slope}. Caution, some fields are not set as they should be updated
 * by business logic.
 */
@Component
public class RequestToSlopeFunction implements BiFunction<UUID, PutSlopeRequest, Slope> {

    @Override
    public Slope apply(UUID id, PutSlopeRequest request) {
        return Slope.builder()
                .id(id)
                .name(request.getName())
                .steepness(request.getSteepness())
                .skiResort(SkiResort.builder()
                        .id(request.getSkiResort())
                        .build())
                .build();
    }

}
