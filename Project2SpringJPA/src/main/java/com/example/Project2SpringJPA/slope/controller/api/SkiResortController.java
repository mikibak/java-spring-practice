package com.example.Project2SpringJPA.slope.controller.api;

import com.example.Project2SpringJPA.slope.dto.GetSkiResortResponse;
import com.example.Project2SpringJPA.slope.dto.GetSkiResortsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Controller for ski resort resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface SkiResortController {

    /**
     * @return list of ski resorts
     */
    @GetMapping("api/skiResorts")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSkiResortsResponse getSkiResorts();

    /**
     * @param id ski resort's id
     * @return single ski resort
     */
    @GetMapping("/api/skiResorts/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSkiResortResponse getSkiResort(
            @PathVariable("id")
            UUID id
    );

    /**
     * Deletes selected ski resort.
     *
     * @param id ski resort's id

    @DeleteMapping("/api/skiResorts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSkiResort(
            @PathVariable("id")
            UUID id
    );
*/
}
