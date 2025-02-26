package com.lab.function;

import com.lab.dto.GetAliensResponse;
import com.lab.entity.Alien;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class AliensToResponseFunction implements Function<List<Alien>, GetAliensResponse> {
    @Override
    public GetAliensResponse apply(List<Alien> aliens) {
        return GetAliensResponse.builder()
                .aliens(aliens.stream()
                        .map(alien -> GetAliensResponse.Alien.builder()
                                .id(alien.getId())
                                .name(alien.getName())
                                .build())
                        .toList())
                .build();
    }
}
