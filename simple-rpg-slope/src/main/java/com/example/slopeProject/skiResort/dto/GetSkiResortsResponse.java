package com.example.slopeProject.skiResort.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSkiResortsResponse {

    /**
     * Represents single ski resort in list.
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
     * List of all skiResorts.
     */
    private List<SkiResort> skiResorts;

}
