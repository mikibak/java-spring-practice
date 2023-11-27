package com.example.skiResort.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.skiResort.dto.GetSkiResortResponse;
import com.example.skiResort.dto.GetSkiResortsResponse;

import java.util.UUID;

/**
 * Controller for skiResort resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface SkiResortController {

    /**
     * @return list of skiResorts
     */
    @GetMapping("api/skiResorts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSkiResortsResponse getSkiResorts();

    /**
     * @param id skiResort's id
     * @return single skiResort
     */
    @GetMapping("/api/skiResorts/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSkiResortResponse getSkiResort(
            @PathVariable("id")
            UUID id
    );


    /**
     * Deletes selected skiResort.
     *
     * @param id skiResort's id
     */
    @DeleteMapping("/api/skiResorts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSkiResort(
            @PathVariable("id")
            UUID id
    );

}
