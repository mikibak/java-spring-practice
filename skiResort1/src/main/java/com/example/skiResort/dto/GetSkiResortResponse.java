package com.example.skiResort.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import com.example.skiResort.entity.SkiResort;

import java.util.Map;
import java.util.UUID;

/**
 * GET skiResort response. Described details about selected skiResort. Can be used to present description while
 * slope creation or on slope's stat page. How skiResort is described is defined in
 * {@link SkiResort}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSkiResortResponse {

    /**
     * Unique id identifying skiResort.
     */
    private UUID id;

    /**
     * Name of the skiResort.
     */
    private String name;

    /**
     * Visitors last year.
     */
    private int visitors;

}
