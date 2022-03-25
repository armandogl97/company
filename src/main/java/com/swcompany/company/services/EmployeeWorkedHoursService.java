package com.swcompany.company.services;

import com.swcompany.company.dtos.EmployeeWorkedHoursDTO;
import com.swcompany.company.entities.Employee;
import com.swcompany.company.entities.EmployeeWorkedHours;
import com.swcompany.company.repository.EmployeeWorkedHoursRepository;
import com.swcompany.company.utils.DateTools;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class EmployeeWorkedHoursService {

    private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
    private EmployeeService employeeService;

    public EmployeeWorkedHoursService(EmployeeWorkedHoursRepository employeeWorkedHoursRepository, EmployeeService employeeService) {
        this.employeeWorkedHoursRepository = employeeWorkedHoursRepository;
        this.employeeService = employeeService;
    }

    public EmployeeWorkedHoursDTO create(EmployeeWorkedHoursDTO body) throws ParseException {
        validateRegisterHours(body);
        EmployeeWorkedHours employeeWorkedHours = new EmployeeWorkedHours();
        employeeWorkedHours.setEmployeeId(body.getEmployeeId() != null ? new Employee(body.getEmployeeId()) : null);
        employeeWorkedHours.setWorkedHours(body.getWorkedHours());
        employeeWorkedHours.setWorkedDate(body.getWorkedDate());
        return EmployeeWorkedHoursDTO.toDTO(employeeWorkedHoursRepository.save(employeeWorkedHours));
    }

    public void validateRegisterHours(EmployeeWorkedHoursDTO body) throws ParseException {
      employeeService.validateExists(body.getEmployeeId());
      if (DateTools.DB_FORMAT.parse(body.getWorkedDate()).after(new Date(System.currentTimeMillis())) ||
              employeeWorkedHoursRepository.duplicateRecordPerDay(body.getWorkedDate()) == 1 || body.getWorkedHours() > 20) {
        throw new NullPointerException();
      }
    }

    public Integer getHoursByEmployee(EmployeeWorkedHoursDTO body) throws ParseException {
        findHoursValidator(body);
        return employeeWorkedHoursRepository.hoursByEmployee(body.getEmployeeId(), body.getStartDate(), body.getEndDate());
    }

    public void findHoursValidator(EmployeeWorkedHoursDTO body) throws ParseException {
        employeeService.validateExists(body.getEmployeeId());
        if (DateTools.DB_FORMAT.parse(body.getEndDate()).before(DateTools.DB_FORMAT.parse(body.getStartDate()))) {
            throw new NullPointerException();
        }
    }



}