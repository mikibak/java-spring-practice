package com.example.SkiResortProject.skiResort.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetSkiResortResponse {
    /**
     * Unique id identifying ski resort.
     */
    private UUID id;

    /**
     * Name of the ski resort.
     */
    private String name;

    /**
     * Number of visitors per season
     */
    private int visitors;

}
