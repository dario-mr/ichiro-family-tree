package com.dario.ift.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AWS Elastic Beanstalk requires the presence of the "/" endpoint to read the health status from.
 * I was not able to change this configuration to e.g. "/health", so I created the "/" endpoint and removed the redirection to "/swagger-ui".
 * Would be nice to improve.
 */
@RestController
public class BaseController {

    @GetMapping("/")
    public ResponseEntity<?> getApplicationHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
