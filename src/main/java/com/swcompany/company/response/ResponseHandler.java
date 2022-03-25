package com.swcompany.company.response;

import com.swcompany.company.dtos.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(boolean success, Integer id, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("success", success);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> generateResponseHours(boolean success, Integer hours, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total_worked_hours", hours);
        map.put("success", success);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> generateResponsePayment(boolean success, Integer payment, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("payment", payment);
        map.put("success", success);
        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> generateEmployeesPerJob(boolean success, Set<EmployeeDTO> employees, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> employee = new HashMap<String, Object>();
        employees.forEach(employeeSingle -> {
            employee.put("id",employeeSingle.getId());
            employee.put("name",employeeSingle.getName());
            employee.put("las_name",employeeSingle.getLastName());
            employee.put("birthdate",employeeSingle.getBirthdate());
            Map<String, Object> job = new HashMap<String, Object>();
            job.put("id",employeeSingle.getJobId());
            Map<String, Object> gender = new HashMap<String, Object>();
            job.put("gender",employeeSingle.getGenderId());
            employee.put("job",job);
            employee.put("gender",gender);
        });
        map.put("employees", employee);
        map.put("success", success);
        return new ResponseEntity<Object>(map,status);
    }
}