package com.swcompany.company.controllers;

import com.swcompany.company.dtos.EmployeeDTO;
import com.swcompany.company.response.ResponseHandler;
import com.swcompany.company.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/employees")
@CrossOrigin(origins = "*")
@Validated
public class EmployeeCtrl {

  private EmployeeService employeeService;


  public EmployeeCtrl(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping(path = "/create")
  public ResponseEntity<Object> create(@Valid @RequestBody EmployeeDTO body) {
    try {
      EmployeeDTO result = employeeService.create(body);
      return ResponseHandler.generateResponse(true, result.getId(), HttpStatus.OK);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(false, null, HttpStatus.MULTI_STATUS);
    }
  }
}