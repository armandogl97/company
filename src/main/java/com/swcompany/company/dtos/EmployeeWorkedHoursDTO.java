package com.swcompany.company.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swcompany.company.entities.Employee;
import com.swcompany.company.entities.EmployeeWorkedHours;
import lombok.Data;

import java.util.Optional;

@Data
public class EmployeeWorkedHoursDTO {

  private Integer id;
  @JsonProperty("employee_id") private Integer employeeId;
  @JsonProperty("worked_hours") private Integer workedHours;
  @JsonProperty("worked_date") private String workedDate;
  @JsonProperty("start_date") private String startDate;
  @JsonProperty("end_date") private String endDate;

  public static EmployeeWorkedHoursDTO toDTO(EmployeeWorkedHours entity) {
    EmployeeWorkedHoursDTO dto = new EmployeeWorkedHoursDTO();
    dto.id = entity.getId();
    dto.employeeId = Optional.ofNullable(entity.getEmployeeId()).orElse(new Employee()).getId();
    dto.workedHours =  entity.getWorkedHours();
    dto.workedDate = entity.getWorkedDate();
    return dto;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public Integer getWorkedHours() {
    return workedHours;
  }

  public void setWorkedHours(Integer workedHours) {
    this.workedHours = workedHours;
  }

  public String getWorkedDate() {
    return workedDate;
  }

  public void setWorkedDate(String workedDate) {
    this.workedDate = workedDate;
  }

}