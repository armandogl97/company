package com.swcompany.company.repository;

import com.swcompany.company.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{
    @Query("select ts from Job ts")
    Set<Job> findAllFetched();
}