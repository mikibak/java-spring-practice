package com.example.skiResortProject.skiResort.function;

import org.springframework.stereotype.Component;
import com.example.skiResortProject.skiResort.dto.GetSkiResortResponse;
import com.example.skiResortProject.skiResort.entity.SkiResort;

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
