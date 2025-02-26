package com.lab.function;

import com.lab.dto.PatchAlienRequest;
import com.lab.entity.Alien;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateAlienWithRequestFunction implements BiFunction<Alien, PatchAlienRequest, Alien> {

    @Override
    public Alien apply(Alien alien, PatchAlienRequest request) {
        return Alien.builder()
                .id(alien.getId())
                .power(request.getPower())
                .name(request.getName())
                .mothership(alien.getMothership())
                .build();
    }
}
