package com.swcompany.company.repository;

import com.swcompany.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    @Query(value = "select * from employees b where b.job_id = :id", nativeQuery = true)
    Set<Employee> findAllPerJob(@Param("id") Integer id);

    @Query(value = "select count(id) from employees e " +
            "where e.NAME = :name and e.LAST_NAME = :lastName limit 1", nativeQuery = true)
    int duplicateEmployee(@Param("name") String name, @Param("lastName") String lastName);
}