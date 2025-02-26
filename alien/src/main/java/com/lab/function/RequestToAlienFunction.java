package com.lab.function;

import com.lab.dto.PutAlienRequest;
import com.lab.entity.Alien;
import com.lab.entity.Mothership;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToAlienFunction implements BiFunction<UUID, PutAlienRequest, Alien> {

    @Override
    public Alien apply(UUID uuid, PutAlienRequest request) {
        return Alien.builder()
                .id(uuid)
                .name(request.getName())
                .power(request.getPower())
                .mothership(Mothership.builder()
                        .id(request.getMothershipId())
                        .build())
                .build();
    }
}
