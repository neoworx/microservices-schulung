package io.reflectoring.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "leistungspakete")
public class Leistungspaket {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotEmpty(message = "The full name is required.")
  @NotNull
  private String name;

  private int preis;

  public Leistungspaket(String name) {
    this.name = name;
    this.preis = 0;
  }

  public Leistungspaket() {
  }

  public int getPreis() {
    return preis;
  }

  public void setPreis(int preis) {
    this.preis = preis;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
