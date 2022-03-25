package com.swcompany.company.dtos;

import com.swcompany.company.entities.Gender;
import lombok.Data;

@Data
public class GenderDTO {

  private Integer id;
  private String name;

  public static GenderDTO toDTO(Gender entity) {
    GenderDTO dto = new GenderDTO();
    dto.id = entity.getId();
    dto.name = entity.getName();
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

}