package com.lab.service;

import com.lab.entity.Alien;
import com.lab.repository.AlienRepository;
import com.lab.repository.MothershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlienService {
    AlienRepository repository;
    MothershipRepository mothershipRepository;

    @Autowired
    public AlienService(
            AlienRepository repository,
            MothershipRepository mothershipRepository
    ) {
        this.repository = repository;
        this.mothershipRepository = mothershipRepository;
    }

    public Optional<Alien> find(String name) {
        return repository.findByName(name);
    }

    public Optional<Alien> find(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Alien> findAll() {
        return repository.findAll();
    }

    public Optional<List<Alien>> findAllByMothership(UUID mothershipId) {
        return mothershipRepository.findById(mothershipId).map(repository::findAllByMothership);
    }

    public void create(Alien alien) {
        repository.save(alien);
    }

    public void update(Alien alien) {
        repository.save(alien);
    }

    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }

    public void delete(UUID uuid) {
        repository.findById(uuid).ifPresent(repository::delete);
    }
}
