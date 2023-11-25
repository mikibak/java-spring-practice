package com.example.SkiResortProject.skiResort.repository.api;

import com.example.SkiResortProject.skiResort.entity.SkiResort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, UUID> {
}
