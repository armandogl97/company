package com.swcompany.company.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swcompany.company.dtos.EmployeeWorkedHoursDTO;
import com.swcompany.company.response.ResponseHandler;
import com.swcompany.company.services.EmployeeWorkedHoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/worked-hours")
@CrossOrigin(origins = "*")
@Validated
public class EmployeeWorkedHoursCtrl {

    private EmployeeWorkedHoursService employeeWorkedHoursService;

    public EmployeeWorkedHoursCtrl(EmployeeWorkedHoursService employeeWorkedHoursService) {
        this.employeeWorkedHoursService = employeeWorkedHoursService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<Object> create(@Valid @RequestBody EmployeeWorkedHoursDTO body) {
        try {
            EmployeeWorkedHoursDTO result = employeeWorkedHoursService.create(body);
            return ResponseHandler.generateResponse(true, result.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(false, null, HttpStatus.MULTI_STATUS);
        }
    }

    @PostMapping(path = "/employeeByDate")
    public ResponseEntity<Object> findHoursByEmployeePost(@Valid @RequestBody EmployeeWorkedHoursDTO body) {
        try {
            Integer hours = employeeWorkedHoursService.getHoursByEmployee(body);
            return ResponseHandler.generateResponseHours(true, hours, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateResponseHours(false, null, HttpStatus.MULTI_STATUS);
        }
    }

    @GetMapping(path = "/employeeByDate")
    public ResponseEntity<Object> findHoursByEmployeeGet(@RequestParam String json) throws JsonMappingException, JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EmployeeWorkedHoursDTO employeeWorkedHoursDTO = objectMapper.readValue(json, EmployeeWorkedHoursDTO.class);
            Integer hours = employeeWorkedHoursService.getHoursByEmployee(employeeWorkedHoursDTO);
            return ResponseHandler.generateResponseHours(true, hours, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateResponseHours(false, null, HttpStatus.MULTI_STATUS);
        }
    }

}