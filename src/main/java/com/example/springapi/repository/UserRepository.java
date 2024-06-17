package com.example.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springapi.models.MyUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String username);
}
