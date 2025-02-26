package com.lab.function;

import com.lab.dto.PutMothershipRequest;
import com.lab.entity.Mothership;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMothershipFunction implements BiFunction<UUID, PutMothershipRequest, Mothership> {

    @Override
    public Mothership apply(UUID uuid, PutMothershipRequest request) {
        return Mothership.builder()
                .id(uuid)
                .name(request.getName())
                .power(request.getPower())
                .build();
    }
}
