package com.example.Project2SpringJPA.slope.repository.api;

import com.example.Project2SpringJPA.slope.entity.SkiResort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, UUID> {

}
