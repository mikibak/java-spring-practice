package com.example.slopeProject.slope.function;

import com.example.slopeProject.slope.dto.PatchSlopeRequest;
import com.example.slopeProject.slope.entity.Slope;

import java.util.function.BiFunction;

/**
 * Returns new instance of {@link Slope} based on provided value and updated with values from
 * {@link PatchSlopeRequest}.
 */
public class UpdateSlopeWithRequestFunction implements BiFunction<Slope, PatchSlopeRequest, Slope> {

    @Override
    public Slope apply(Slope entity, PatchSlopeRequest request) {
        return Slope.builder()
                .id(entity.getId())
                .name(request.getName())
                .skiResort(entity.getSkiResort())
                .steepness(entity.getSteepness())
                .build();
    }

}
