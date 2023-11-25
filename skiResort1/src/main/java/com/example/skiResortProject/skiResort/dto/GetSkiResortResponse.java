package com.example.skiResortProject.skiResort.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import com.example.skiResortProject.skiResort.entity.SkiResort;

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
     * Describes single skill. Returning skiResort description without skills list would not give all required
     * information. Forcing to return list of skills in separate request would be unnecessary transfer growth. How
     * skills are described is defined in {@link pl.edu.pg.eti.kask.rpg.slope.entity.Skill}.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Skill {

        /**
         * Unique id identifying skill.
         */
        private UUID id;

        /**
         * Name of the skill.
         */
        private String name;

        /**
         * Description of the skill.
         */
        private String description;

    }

    /**
     * Unique id identifying skiResort.
     */
    private UUID id;

    /**
     * Name of the skiResort.
     */
    private String name;

    /**
     * Set of skills available to this skiResort on different levels.
     */
    @Singular
    private Map<Integer, Skill> skills;

}
