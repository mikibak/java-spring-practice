package com.example.Project2SpringJPA.slope.dto;

import lombok.*;

/**
 * PATCH slope request. Contains all fields that can be updated by the user. How slope is described is defined
 * in {@link GetSlopesResponse.Slope}  class.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class PatchSlopeRequest {

    /**
     * Slope's name.
     */
    private String name;

    /**
     * Slope's steepness.
     */
    private int steepness;

}
