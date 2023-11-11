package com.example.Project2SpringJPA.slope.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * PATCH slope request. Contains all fields that can be updated by the user. How slope is described is defined
 * in {@link GetSlopesResponse.Slope}  class.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchSlopeRequest {

    /**
     * Character's name.
     */
    private String name;

    /**
     * Slope's steepness.
     */
    private int steepness;

}
