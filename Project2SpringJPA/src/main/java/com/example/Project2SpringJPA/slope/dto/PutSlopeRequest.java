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
 * PUT slope request. Contains only fields that can be set up byt the user while creating a new slope.How
 * slope is described is defined in {@link GetSlopesResponse.Slope} class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutSlopeRequest {

    /**
     * Name of the slope.
     */
    private String name;

    /**
     * Slope's steepness
     */
    private int steepness;

    /**
     * Identifier of the slope's skiResort.
     */
    private UUID skiResort;

}
