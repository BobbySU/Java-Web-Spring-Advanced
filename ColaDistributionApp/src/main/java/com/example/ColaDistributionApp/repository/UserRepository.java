package com.example.ColaDistributionApp.repository;

import com.example.ColaDistributionApp.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}




