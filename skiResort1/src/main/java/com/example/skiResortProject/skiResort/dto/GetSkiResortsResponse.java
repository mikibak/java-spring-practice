package com.example.skiResortProject.skiResort.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * GET skiResorts response. Returns list of all available skiResorts names.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSkiResortsResponse {

    /**
     * Represents single skiResort in list.
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
         * Unique id identifying skiResort.
         */
        private UUID id;

        /**
         * Name of the skiResort.
         */
        private String name;

    }

    /**
     * List of all skiResorts.
     */
    private List<SkiResort> skiResorts;

}
