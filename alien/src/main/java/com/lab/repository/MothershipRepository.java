package com.lab.repository;

import com.lab.entity.Mothership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MothershipRepository extends JpaRepository<Mothership, UUID> {

}
