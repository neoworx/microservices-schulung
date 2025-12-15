package io.reflectoring.demo.service;

import io.reflectoring.demo.model.Leistungspaket;
import io.reflectoring.demo.repository.LeistungspaketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeistungspaketService {

  @Autowired
  private LeistungspaketRepository leistungspaketRepository;

  public List<Leistungspaket> retrieveLeistungspakete() {
    return leistungspaketRepository.findAll();
  }

  public void insertLeistungspaket(Leistungspaket leistungspaket) {
    leistungspaketRepository.save(leistungspaket);
  }
}
