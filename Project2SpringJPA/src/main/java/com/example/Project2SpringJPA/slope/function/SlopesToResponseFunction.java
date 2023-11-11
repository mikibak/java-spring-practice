package com.example.Project2SpringJPA.slope.function;

import com.example.Project2SpringJPA.slope.dto.GetSlopesResponse;
import com.example.Project2SpringJPA.slope.entity.Slope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

/**
 * Coverts {@link List<Slope>} to {@link GetSlopesResponse}.
 */
@Component
public class SlopesToResponseFunction implements Function<List<Slope>, GetSlopesResponse> {

    @Override
    public GetSlopesResponse apply(List<Slope> entities) {
        return GetSlopesResponse.builder()
                .slopes(entities.stream()
                        .map(slope -> GetSlopesResponse.Slope.builder()
                                .id(slope.getId())
                                .name(slope.getName())
                                .build())
                        .toList())
                .build();
    }

}
