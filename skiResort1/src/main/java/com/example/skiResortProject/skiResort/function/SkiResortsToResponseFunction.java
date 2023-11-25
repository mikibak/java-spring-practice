package com.example.skiResortProject.skiResort.function;

import org.springframework.stereotype.Component;
import com.example.skiResortProject.skiResort.dto.GetSkiResortsResponse;
import com.example.skiResortProject.skiResort.entity.SkiResort;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<SkiResort>} to {@link GetSkiResortsResponse}.
 */
@Component
public class SkiResortsToResponseFunction implements Function<List<SkiResort>, GetSkiResortsResponse> {

    @Override
    public GetSkiResortsResponse apply(List<SkiResort> entities) {
        return GetSkiResortsResponse.builder()
                .skiResorts(entities.stream()
                        .map(skiResort -> GetSkiResortsResponse.SkiResort.builder()
                                .id(skiResort.getId())
                                .name(skiResort.getName())
                                .build())
                        .toList())
                .build();
    }

}
