package com.swcompany.company.repository;

import com.swcompany.company.entities.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHours, Integer>{

    @Query(value = "select count(id) from employee_worked_hours e " +
            "where e.WORKED_DATE = :date limit 1", nativeQuery = true)
    int duplicateRecordPerDay(@Param("date") String date);

    @Query(value = "select SUM(worked_hours) from employee_worked_hours e " +
            "where e.employee_id = :id and e.worked_date BETWEEN :date1 and :date2", nativeQuery = true)
    int hoursByEmployee(@Param("id") Integer id, @Param("date1") String date1, @Param("date2") String date2);

}