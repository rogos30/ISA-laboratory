package com.lab.controller;

import com.lab.dto.PutMothershipRequest;
import com.lab.function.RequestToMothershipFunction;
import com.lab.service.MothershipService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class MothershipController {
    MothershipService service;
    RequestToMothershipFunction requestToMothership;

    @Autowired
    MothershipController(MothershipService service, RequestToMothershipFunction requestToMothership) {
        this.service = service;
        this.requestToMothership = requestToMothership;
    }

    @PutMapping("/api/motherships/{mothershipId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createMothership(@PathVariable UUID mothershipId, @RequestBody PutMothershipRequest request) {
        service.create(requestToMothership.apply(mothershipId, request));
    }

    @DeleteMapping("/api/motherships/{mothershipId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMothership(@PathVariable UUID mothershipId) {
        service.find(mothershipId)
                .ifPresentOrElse(
                        mothership -> service.delete(mothershipId),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
