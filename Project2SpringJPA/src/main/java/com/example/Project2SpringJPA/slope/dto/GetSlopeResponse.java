package com.example.Project2SpringJPA.slope.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * GET slope response. It contains all field that can be presented (but not necessarily changed) to the used. How
 * character is described is defined in {@link GetSlopesResponse[esResponse.Slope}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSlopeResponse {

    /**
     * Represents single SkiResort.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class SkiResort {

        /**
         * Unique id identifying ski resort.
         */
        private UUID id;

        /**
         * Name of the ski resort.
         */
        private String name;

    }

    /**
     * Unique id identifying slope.
     */
    private UUID id;

    /**
     * Name of the slope.
     */
    private String name;

    /**
     * Slope's steepness.
     */
    private int steepness;

    /**
     * Slope's skiResort.
     */
    private SkiResort skiResort;

}
