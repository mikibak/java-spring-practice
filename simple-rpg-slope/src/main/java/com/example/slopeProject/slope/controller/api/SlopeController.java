package com.example.slopeProject.slope.controller.api;

import com.example.slopeProject.slope.dto.GetSlopeResponse;
import com.example.slopeProject.slope.dto.GetSlopesResponse;
import com.example.slopeProject.slope.dto.PatchSlopeRequest;
import com.example.slopeProject.slope.dto.PutSlopeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SlopeController {

    /**
     * @return list of slopes
     */
    @GetMapping("api/slopes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSlopesResponse getSlopes();

    /**
     * @param skiResortId slope's ski resort
     * @return list of slopes
     */
    @GetMapping("/api/skiResorts/{skiResortId}/slopes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSlopesResponse getSkiResortSlopes(
            @PathVariable("skiResortId")
            UUID skiResortId
    );

    /**
     * @param id slope's id
     * @return single slope
     */
    @GetMapping("/api/slopes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSlopeResponse getSlope(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param id      slope's id
     * @param request new slope
     */
    @PutMapping("/api/slopes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSlope(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSlopeRequest request
    );

    /**
     * Deletes selected slope.
     *
     * @param id slope's id
     */
    @DeleteMapping("/api/slopes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSlope(
            @PathVariable("id")
            UUID id
    );


    /**
     * @param id      slope's id
     * @param request new slope
     */
    @PatchMapping("/api/slopes/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchSlope(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchSlopeRequest request
    );

}
