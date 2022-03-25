package com.swcompany.company.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swcompany.company.dtos.EmployeeDTO;
import com.swcompany.company.dtos.EmployeeWorkedHoursDTO;
import com.swcompany.company.repository.JobRepository;
import com.swcompany.company.response.ResponseHandler;
import com.swcompany.company.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/jobs")
@CrossOrigin(origins = "*")
@Validated
public class JobCtrl {

    private JobService jobService;
    private JobRepository jobRepository;

    public JobCtrl(JobService jobService, JobRepository jobRepository) {
        this.jobService = jobService;
        this.jobRepository = jobRepository;
    }

    @GetMapping(path = "/employees-per-job")
    public ResponseEntity<Object> employeesPerJob(@RequestParam String json) throws JsonMappingException, JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EmployeeDTO employee = objectMapper.readValue(json, EmployeeDTO.class);
            Set<EmployeeDTO> employees = jobService.getAllEmployeesPerJobs(employee);
            return ResponseHandler.generateEmployeesPerJob(true, employees, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateEmployeesPerJob(false, null, HttpStatus.MULTI_STATUS);
        }
    }

    @PostMapping(path = "/total-payment-employee")
    public ResponseEntity<Object> totalPaymentEmployeePost(@Valid @RequestBody EmployeeWorkedHoursDTO body) {
        try {
            Integer payment = jobService.getPayment(body);
            return ResponseHandler.generateResponseHours(true, payment, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateResponseHours(false, null, HttpStatus.MULTI_STATUS);
        }
    }

    @GetMapping(path = "/total-payment-employee")
    public ResponseEntity<Object> totalPaymentEmployeeGet(@RequestParam String json) throws JsonMappingException, JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EmployeeWorkedHoursDTO employeeWorkedHoursDTO = objectMapper.readValue(json, EmployeeWorkedHoursDTO.class);
            Integer payment = jobService.getPayment(employeeWorkedHoursDTO);
            return ResponseHandler.generateResponseHours(true, payment, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateResponseHours(false, null, HttpStatus.MULTI_STATUS);
        }
    }

}
