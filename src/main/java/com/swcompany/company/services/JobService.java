package com.swcompany.company.services;

import com.swcompany.company.dtos.EmployeeDTO;
import com.swcompany.company.dtos.EmployeeWorkedHoursDTO;
import com.swcompany.company.repository.EmployeeRepository;
import com.swcompany.company.repository.EmployeeWorkedHoursRepository;
import com.swcompany.company.repository.JobRepository;
import com.swcompany.company.utils.DateTools;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobService {
  private JobRepository jobRepository;
  private EmployeeRepository employeeRepository;
  private EmployeeService employeeService;
  private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

  public JobService(@Lazy JobRepository jobRepository, EmployeeRepository employeeRepository, @Lazy EmployeeService employeeService, @Lazy EmployeeWorkedHoursRepository employeeWorkedHoursRepository) {
    this.jobRepository = jobRepository;
    this.employeeRepository = employeeRepository;
    this.employeeService = employeeService;
    this.employeeWorkedHoursRepository = employeeWorkedHoursRepository;
  }

  public Set<EmployeeDTO> getAllEmployeesPerJobs(EmployeeDTO body) throws ParseException {
    return employeeRepository.findAllPerJob(body.getJobId()).parallelStream()
            .map(EmployeeDTO::toDTO).collect(Collectors.toSet());
  }

  public Integer getPayment(EmployeeWorkedHoursDTO body) throws ParseException {
    findPaymentValidator(body);
    Integer hours = employeeWorkedHoursRepository.hoursByEmployee(body.getEmployeeId(), body.getStartDate(), body.getEndDate());
    Integer salary = (int)employeeService.get(body.getEmployeeId()).get().getJobId().getSalary();
    return hours * salary;
  }

  public void findPaymentValidator(EmployeeWorkedHoursDTO body) throws ParseException {
    employeeService.validateExists(body.getEmployeeId());
    if (DateTools.DB_FORMAT.parse(body.getEndDate()).before(DateTools.DB_FORMAT.parse(body.getStartDate()))) {
      throw new NullPointerException();
    }
  }

  public void validateExists(Integer id) {
    if (id != null && !jobRepository.existsById(id)) {
      throw new NullPointerException();
    }
  }

}