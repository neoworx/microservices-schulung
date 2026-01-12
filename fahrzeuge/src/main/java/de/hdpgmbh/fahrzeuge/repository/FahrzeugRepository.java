package de.hdpgmbh.fahrzeuge.repository;

import de.hdpgmbh.fahrzeuge.model.Fahrzeug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrzeugRepository
    extends JpaRepository<Fahrzeug, String> {

}


