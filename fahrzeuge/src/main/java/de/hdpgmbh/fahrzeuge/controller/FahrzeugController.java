package de.hdpgmbh.fahrzeuge.controller;

import de.hdpgmbh.fahrzeuge.model.Fahrzeug;
import de.hdpgmbh.fahrzeuge.service.FahrzeugService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FahrzeugController {

  @Autowired
  private FahrzeugService fahrzeugService;

  @GetMapping("/fahrzeuge")
  public List<Fahrzeug> getFahrzeuge() {
    return fahrzeugService.retrieveFahrzeuge();
  }

  @PostMapping("/fahrzeuge")
  public void createFahrzeug(@RequestBody @Valid Fahrzeug fahrzeug) {
    fahrzeugService.insertFahrzeug(fahrzeug);
  }
}
