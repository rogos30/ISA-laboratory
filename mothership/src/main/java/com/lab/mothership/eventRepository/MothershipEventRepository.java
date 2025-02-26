package com.lab.mothership.eventRepository;

import com.lab.mothership.entity.Mothership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class MothershipEventRepository {
    RestTemplate restTemplate;

    @Autowired
    public MothershipEventRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/motherships/{id}", id);
    }

    public void create(Mothership mothership) {
        restTemplate.put("/api/motherships/{id}", mothership, mothership.getId());
    }
}
