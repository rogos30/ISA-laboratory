package com.lab.controller;

import com.lab.dto.GetAlienResponse;
import com.lab.dto.GetAliensResponse;
import com.lab.dto.PutAlienRequest;
import com.lab.function.AlienToResponseFunction;
import com.lab.function.AliensToResponseFunction;
import com.lab.function.RequestToAlienFunction;
import com.lab.service.AlienService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AlienController {
    AlienService service;
    AlienToResponseFunction alienToResponse;
    AliensToResponseFunction aliensToResponse;
    RequestToAlienFunction requestToAlien;

    @Autowired
    public AlienController(
            AlienService service,
            AlienToResponseFunction alienToResponse,
            AliensToResponseFunction aliensToResponse,
            RequestToAlienFunction requestToAlien
    ) {
        this.service = service;
        this.alienToResponse = alienToResponse;
        this.aliensToResponse = aliensToResponse;
        this.requestToAlien = requestToAlien;
    }

    @GetMapping("/api/aliens")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetAliensResponse getAliens() {
        return aliensToResponse.apply(service.findAll());
    }

    @GetMapping("/api/motherships/{mothershipId}/aliens")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetAliensResponse getMothershipCharacters(@PathVariable UUID mothershipId) {
        return service.findAllByMothership(mothershipId)
                .map(aliensToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/aliens/{alienId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetAlienResponse getAlien(@PathVariable UUID alienId) {
        return service.find(alienId)
                .map(alienToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/aliens/{alienId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putAlien(@PathVariable UUID alienId, @RequestBody PutAlienRequest request) {
        service.create(requestToAlien.apply(alienId, request));
    }

    @DeleteMapping("/api/aliens/{alienId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlien(@PathVariable UUID alienId) {
        System.out.println("deleting alien");
        service.find(alienId).ifPresentOrElse(
                alien -> service.delete(alienId),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
