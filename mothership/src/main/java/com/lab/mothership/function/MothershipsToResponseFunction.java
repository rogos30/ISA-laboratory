package com.lab.mothership.function;

import com.lab.mothership.dto.GetMothershipsResponse;
import com.lab.mothership.entity.Mothership;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MothershipsToResponseFunction implements Function<List<Mothership>, GetMothershipsResponse> {
    @Override
    public GetMothershipsResponse apply(List<Mothership> motherships) {
        return GetMothershipsResponse.builder()
                .motherships(motherships.stream()
                        .map(mothership -> GetMothershipsResponse.Mothership.builder()
                                .id(mothership.getId())
                                .name(mothership.getName())
                                .power(mothership.getPower())
                                .build())
                        .toList())
                .build();
    }
}
