package com.example.springapi.api.repository;

import com.example.springapi.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}
