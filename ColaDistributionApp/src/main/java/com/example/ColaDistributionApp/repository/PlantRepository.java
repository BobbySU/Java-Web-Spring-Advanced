package com.example.ColaDistributionApp.repository;

import com.example.ColaDistributionApp.models.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant,String> {
}
