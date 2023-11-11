package com.example.Project2SpringJPA.slope.controller.impl;

import com.example.Project2SpringJPA.slope.controller.api.SlopeController;
import com.example.Project2SpringJPA.slope.dto.GetSlopesResponse;
import com.example.Project2SpringJPA.slope.service.api.SlopeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.Project2SpringJPA.slope.dto.GetSlopeResponse;
import com.example.Project2SpringJPA.slope.dto.PutSlopeRequest;
import com.example.Project2SpringJPA.slope.entity.Slope;
import com.example.Project2SpringJPA.slope.function.SlopeToResponseFunction;
import com.example.Project2SpringJPA.slope.function.SlopesToResponseFunction;
import com.example.Project2SpringJPA.slope.function.RequestToSlopeFunction;

import java.util.List;
import java.util.UUID;

/**
 * Controller for slope resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class SlopeDefaultController implements SlopeController {

    /**
     * Service for managing slopes.
     */
    private final SlopeService service;

    /**
     * Converts {@link Slope} to {@link GetSlopeResponse}.
     */
    private final SlopeToResponseFunction slopeToResponse;

    /**
     * Coverts {@link List <Slope>} to {@link GetSlopesResponse}.
     */
    private final SlopesToResponseFunction slopesToResponse;

    /**
     * Converts {@link PutSlopeRequest} to {@link Slope}.
     */
    private final RequestToSlopeFunction requestToSlope;

    /**
     * @param service              service for managing slopes
     * @param slopeToResponse  converts {@link Slope} to {@link GetSlopeResponse}
     * @param slopesToResponse coverts {@link List <Slope>} to {@link GetSlopesResponse}
     * @param requestToSlope   converts {@link PutSlopeRequest} to {@link Slope}
     */
    @Autowired
    public SlopeDefaultController(
            SlopeService service,
            SlopeToResponseFunction slopeToResponse,
            SlopesToResponseFunction slopesToResponse,
            RequestToSlopeFunction requestToSlope
    ) {
        this.service = service;
        this.slopeToResponse = slopeToResponse;
        this.slopesToResponse = slopesToResponse;
        this.requestToSlope = requestToSlope;
    }

    @Override
    public GetSlopesResponse getSlopes() {
        return slopesToResponse.apply(service.findAll());
    }

    @Override
    public GetSlopesResponse getSkiResortSlopes(UUID professionId) {
        return service.findAllBySkiResort(professionId)
                .map(slopesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetSlopeResponse getSlope(UUID id) {
        return service.find(id)
                .map(slopeToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putSlope(UUID id, PutSlopeRequest request) {
        service.create(requestToSlope.apply(id, request));
    }

    @Override
    public void deleteSlope(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        slope -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
