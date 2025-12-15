package io.reflectoring.demo.controller;

import io.reflectoring.demo.model.Leistungspaket;
import io.reflectoring.demo.service.LeistungspaketService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeistungspaketController {

  @Autowired
  private LeistungspaketService leistungspaketService;

  @GetMapping("/leistungspakete")
  public List<Leistungspaket> getLeistungspakete() {
    return leistungspaketService.retrieveLeistungspakete();
  }

  @io.swagger.v3.oas.annotations.Operation(summary = "Create a new Leistungspaket")
  @PostMapping("/leistungspakete")
  public void createLeistungspaket(@RequestBody @Valid Leistungspaket leistungspaket) {
    leistungspaketService.insertLeistungspaket(leistungspaket);
  }
}
