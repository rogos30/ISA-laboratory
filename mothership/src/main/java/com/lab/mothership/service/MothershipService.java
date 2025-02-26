package com.lab.mothership.service;

import com.lab.mothership.entity.Mothership;
import com.lab.mothership.eventRepository.MothershipEventRepository;
import com.lab.mothership.repository.MothershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MothershipService {
    MothershipRepository repository;
    MothershipEventRepository eventRepository;

    @Autowired
    public MothershipService(MothershipRepository repository, MothershipEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public Optional<Mothership> find(UUID id) {
        return repository.findById(id);
    }

    public Mothership find(String name) {
        return repository.findByName(name);
    }


    public List<Mothership> findAll() {
        return repository.findAll();
    }

    public void create(Mothership mothership) {
        repository.save(mothership);
        eventRepository.create(mothership);
    }

    public void update(Mothership mothership) {
        repository.save(mothership);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
