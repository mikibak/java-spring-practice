package com.example.slopeProject.skiResort.dto;

import lombok.*;

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
