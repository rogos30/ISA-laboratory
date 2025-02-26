package com.lab.repository;

import com.lab.entity.Alien;
import com.lab.entity.Mothership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlienRepository extends JpaRepository<Alien, UUID> {
    Optional<Alien> findByName(String name);

    List<Alien> findAllByMothership(Mothership mothership);
}
