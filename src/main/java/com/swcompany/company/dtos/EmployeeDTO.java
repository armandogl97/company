package com.swcompany.company.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swcompany.company.entities.Employee;
import com.swcompany.company.entities.Gender;
import com.swcompany.company.entities.Job;
import lombok.Data;

import java.util.Optional;

@Data
public class EmployeeDTO {

  private Integer id;
  private String name;
  @JsonProperty("gender_id")  private Integer genderId;
  @JsonProperty("job_id")     private Integer jobId;
  @JsonProperty("last_name")  private String lastName;
  private String birthdate;

  public static EmployeeDTO toDTO(Employee entity) {
    EmployeeDTO dto = new EmployeeDTO();
    dto.id = entity.getId();
    dto.genderId = Optional.ofNullable(entity.getGenderId()).orElse(new Gender()).getId();
    dto.jobId =  Optional.ofNullable(entity.getJobId()).orElse(new Job()).getId();
    dto.name = entity.getName();
    dto.lastName = entity.getLastName();
    dto.birthdate = entity.getBirthdate();
    return dto;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getGenderId() {
    return genderId;
  }

  public void setGenderId(Integer genderId) {
    this.genderId = genderId;
  }

  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }
}