package de.hdpgmbh.fahrzeuge.service;

import de.hdpgmbh.fahrzeuge.model.Fahrzeug;
import de.hdpgmbh.fahrzeuge.repository.FahrzeugRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FahrzeugService {

  @Autowired
  private FahrzeugRepository fahrzeugRepository;

  public List<Fahrzeug> retrieveFahrzeuge() {
    return fahrzeugRepository.findAll();
  }

  public void insertFahrzeug(Fahrzeug fahrzeug) {
    fahrzeugRepository.save(fahrzeug);
  }
}
