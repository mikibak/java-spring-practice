package com.example.Project2SpringJPA.slope.dto;

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
     * List of all professions.
     */
    private List<SkiResort> professions;

}
