package io.reflectoring.demo.repository;

import io.reflectoring.demo.model.Leistungspaket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeistungspaketRepository
    extends JpaRepository<Leistungspaket, String> {

}


