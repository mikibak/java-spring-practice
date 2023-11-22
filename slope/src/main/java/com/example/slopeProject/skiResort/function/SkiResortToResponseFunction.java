package com.example.slopeProject.skiResort.function;

import com.example.slopeProject.skiResort.dto.GetSkiResortResponse;
import com.example.slopeProject.skiResort.entity.SkiResort;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converts {@link SkiResort} to {@link GetSkiResortResponse}.
 */
@Component
public class SkiResortToResponseFunction implements Function<SkiResort, GetSkiResortResponse> {

    @Override
    public GetSkiResortResponse apply(SkiResort entity) {
        return GetSkiResortResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
