package com.lab.mothership.function;

import com.lab.mothership.dto.GetMothershipResponse;
import com.lab.mothership.entity.Mothership;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MothershipToResponseFunction implements Function<Mothership, GetMothershipResponse> {
    @Override
    public GetMothershipResponse apply(Mothership mothership) {
        return GetMothershipResponse.builder()
                .id(mothership.getId())
                .name(mothership.getName())
                .power(mothership.getPower())
                .build();
    }
}
