package com.example.ColaDistributionApp.repository;

import com.example.ColaDistributionApp.models.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,String> {
}
