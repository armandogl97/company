package com.swcompany.company.services;

import com.swcompany.company.repository.GenderRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderService {

  private GenderRepository genderRepository;

  public GenderService(GenderRepository genderRepository) {
    this.genderRepository = genderRepository;
  }

  public void validateExists(Integer id) {
    if (id != null && !genderRepository.existsById(id)) {
      throw new NullPointerException();
    }
  }

}