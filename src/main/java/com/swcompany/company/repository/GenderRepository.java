package com.swcompany.company.repository;

import com.swcompany.company.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{
    @Query("select ts from Gender ts")
    Set<Gender> findAllFetched();
}