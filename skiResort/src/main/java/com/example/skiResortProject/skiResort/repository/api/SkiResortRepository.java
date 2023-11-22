package com.example.skiResortProject.skiResort.repository.api;

import com.example.skiResortProject.skiResort.entity.SkiResort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, UUID> {
}
