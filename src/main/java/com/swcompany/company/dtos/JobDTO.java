package com.swcompany.company.dtos;

import com.swcompany.company.entities.Job;
import lombok.Data;

@Data
public class JobDTO {

  private Integer id;
  private String name;
  private double salary;

  public static JobDTO toDTO(Job entity) {
    JobDTO dto = new JobDTO();
    dto.id = entity.getId();
    dto.name = entity.getName();
    dto.salary = entity.getSalary();
    return dto;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
}