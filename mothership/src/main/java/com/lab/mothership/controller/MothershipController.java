package com.lab.mothership.controller;

import com.lab.mothership.dto.GetMothershipResponse;
import com.lab.mothership.dto.GetMothershipsResponse;
import com.lab.mothership.dto.PutMothershipRequest;
import com.lab.mothership.function.MothershipToResponseFunction;
import com.lab.mothership.function.MothershipsToResponseFunction;
import com.lab.mothership.function.RequestToMothershipFunction;
import com.lab.mothership.service.MothershipService;
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
    MothershipToResponseFunction mothershipToResponse;
    MothershipsToResponseFunction mothershipsToResponse;
    RequestToMothershipFunction requestToMothership;

    @Autowired
    MothershipController(
            MothershipService service,
            MothershipToResponseFunction mothershipToResponse,
            MothershipsToResponseFunction mothershipsToResponse,
            RequestToMothershipFunction requestToMothership
    ) {
        this.service = service;
        this.mothershipToResponse = mothershipToResponse;
        this.mothershipsToResponse = mothershipsToResponse;
        this.requestToMothership = requestToMothership;
    }

    @GetMapping("/api/motherships")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMothershipsResponse getMotherships() {
        return mothershipsToResponse.apply(service.findAll());
    }

    @GetMapping("/api/motherships/{mothershipId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMothershipResponse getMothership(@PathVariable UUID mothershipId) {
        return service.find(mothershipId)
                .map(mothershipToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/motherships/{mothershipId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putMothership(@PathVariable UUID mothershipId, @RequestBody PutMothershipRequest request) {
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
