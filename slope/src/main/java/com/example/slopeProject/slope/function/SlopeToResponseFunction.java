package com.example.Project2SpringJPA.slope.function;

import com.example.Project2SpringJPA.slope.dto.GetSlopeResponse;
import com.example.Project2SpringJPA.slope.entity.Slope;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts {@link Slope} to {@link GetSlopeResponse}.
 */
@Component
public class SlopeToResponseFunction implements Function<Slope, GetSlopeResponse> {

    @Override
    public GetSlopeResponse apply(Slope entity) {
        return GetSlopeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .steepness(entity.getSteepness())
                .skiResort(GetSlopeResponse.SkiResort.builder()
                        .id(entity.getSkiResort().getId())
                        .name(entity.getSkiResort().getName())
                        .build())
                .build();
    }

}
