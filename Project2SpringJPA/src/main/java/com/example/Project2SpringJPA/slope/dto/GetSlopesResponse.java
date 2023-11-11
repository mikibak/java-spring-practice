package com.example.Project2SpringJPA.slope.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * GET slopes response. Contains list of available slopes. Can be used to list particular ski resort's slopes as
 * well as all slopes in the game.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSlopesResponse {

    /**
     * Represents single character in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Slope {

        /**
         * Unique id identifying slope.
         */
        private UUID id;

        /**
         * Name of the slope.
         */
        private String name;

    }

    /**
     * Name of the selected slopes.
     */
    @Singular
    private List<Slope> slopes;

}
