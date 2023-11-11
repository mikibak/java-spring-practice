package com.example.Project2SpringJPA.slope.controller.api;

import com.example.Project2SpringJPA.slope.dto.GetSlopeResponse;
import com.example.Project2SpringJPA.slope.dto.GetSlopesResponse;
import com.example.Project2SpringJPA.slope.dto.PutSlopeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface SlopeController {

    /**
     * @return list of characters
     */
    @GetMapping("api/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSlopesResponse getSlopes();

    /**
     * @param professionId slope's ski resort
     * @return list of slopes
     */
    @GetMapping("/api/skiResorts/{skiResortId}/slopes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSlopesResponse getSkiResortSlopes(
            @PathVariable("skiResortId")
            UUID professionId
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

}
