package com.example.skiResort.controller.impl;

import com.example.skiResort.controller.api.SkiResortController;
import com.example.skiResort.function.SkiResortToResponseFunction;
import com.example.skiResort.function.SkiResortsToResponseFunction;
import com.example.skiResort.service.api.SkiResortService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.skiResort.dto.GetSkiResortResponse;
import com.example.skiResort.dto.GetSkiResortsResponse;
import com.example.skiResort.entity.SkiResort;

import java.util.List;
import java.util.UUID;

/**
 * Controller for skiResort resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class SkiResortDefaultController implements SkiResortController {

    /**
     * Service for managing skiResorts.
     */
    private final SkiResortService service;

    /**
     * Converts {@link SkiResort} to {@link GetSkiResortResponse}.
     */
    private final SkiResortToResponseFunction skiResortToResponse;

    /**
     * Coverts {@link List <SkiResort>} to {@link GetSkiResortsResponse}.
     */
    private final SkiResortsToResponseFunction skiResortsToResponse;

    /**
     * @param service               service for managing skiResorts
     * @param skiResortToResponse  converts {@link SkiResort} to {@link GetSkiResortResponse}
     * @param skiResortsToResponse coverts {@link List <SkiResort>} to {@link GetSkiResortsResponse}
     */
    @Autowired
    public SkiResortDefaultController(
            SkiResortService service,
            SkiResortToResponseFunction skiResortToResponse,
            SkiResortsToResponseFunction skiResortsToResponse
    ) {
        this.service = service;
        this.skiResortToResponse = skiResortToResponse;
        this.skiResortsToResponse = skiResortsToResponse;
    }

    @Override
    public GetSkiResortsResponse getSkiResorts() {
        return skiResortsToResponse.apply(service.findAll());
    }

    @Override
    public GetSkiResortResponse getSkiResort(UUID id) {
        return service.find(id)
                .map(skiResortToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteSkiResort(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        skiResort -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
