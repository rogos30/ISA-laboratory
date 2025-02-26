package com.lab.function;

import com.lab.dto.GetAlienResponse;
import com.lab.entity.Alien;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlienToResponseFunction implements Function<Alien, GetAlienResponse> {
    @Override
    public GetAlienResponse apply(Alien alien) {
        return GetAlienResponse.builder()
                .id(alien.getId())
                .name(alien.getName())
                .power(alien.getPower())
                .mothership(GetAlienResponse.Mothership.builder()
                        .id(alien.getMothership().getId())
                        .name(alien.getMothership().getName())
                        .build())
                .build();
    }
}
