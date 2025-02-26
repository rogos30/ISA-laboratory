package com.lab.service;

import com.lab.repository.MothershipRepository;
import com.lab.entity.Mothership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MothershipService {
    MothershipRepository repository;

    @Autowired
    public MothershipService(MothershipRepository repository) {
        this.repository = repository;
    }

    public Optional<Mothership> find(UUID id) {
        return repository.findById(id);
    }

    public void create(Mothership mothership) {
        repository.save(mothership);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
