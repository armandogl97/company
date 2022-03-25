package com.swcompany.company.services;

import com.swcompany.company.dtos.EmployeeDTO;
import com.swcompany.company.entities.Employee;
import com.swcompany.company.entities.Gender;
import com.swcompany.company.entities.Job;
import com.swcompany.company.repository.EmployeeRepository;
import com.swcompany.company.utils.DateTools;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class EmployeeService {

  private EmployeeRepository employeeRepository;
  private GenderService genderService;
  private JobService jobService;

  public EmployeeService(EmployeeRepository employeeRepository, GenderService genderService, JobService jobService) {
    this.employeeRepository = employeeRepository;
    this.genderService = genderService;
    this.jobService = jobService;
  }

  public Optional<Employee> get(Integer id) {
    return employeeRepository.findById(id);
  }

  public EmployeeDTO create(EmployeeDTO body) {
    validateCreateEmployee(body);
    Employee employee = new Employee();
    employee.setGenderId(body.getGenderId() != null ? new Gender(body.getGenderId()) : null);
    employee.setJobId(body.getJobId() != null ? new Job(body.getJobId()) : null);
    employee.setName(body.getName());
    employee.setLastName(body.getLastName());
    employee.setBirthdate(body.getBirthdate());
    return EmployeeDTO.toDTO(employeeRepository.save(employee));
  }

  public void validateCreateEmployee(EmployeeDTO body) {
    genderService.validateExists(body.getGenderId());
    jobService.validateExists(body.getJobId());
    if ((Calendar.getInstance().get(Calendar.YEAR) - DateTools.returnYear(body.getBirthdate())) <= 17 || employeeRepository.duplicateEmployee(body.getName(), body.getLastName()) != 0)
      throw new NullPointerException();
  }

  public void validateExists(Integer id) {
    if (id != null && !employeeRepository.existsById(id)) {
      throw new NullPointerException();
    }
  }

}