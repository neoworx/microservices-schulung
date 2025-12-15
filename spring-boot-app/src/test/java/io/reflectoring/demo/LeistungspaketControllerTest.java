package io.reflectoring.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;

import io.reflectoring.demo.controller.LeistungspaketController;
import io.reflectoring.demo.model.Leistungspaket;
import io.reflectoring.demo.repository.LeistungspaketRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LeistungspaketControllerTest {

  @Autowired
  private LeistungspaketController leistungspaketController;

  @Autowired
  private LeistungspaketRepository leistungspaketRepository;

  @Test
  void createLeistungspaket_shouldCreateCorrectLeistungspaket() {

    // given
    String leistungspaketName = "Test Leistungspaket";
    Leistungspaket testLeistungspaket = new Leistungspaket(leistungspaketName);

    // when
    leistungspaketController.createLeistungspaket(testLeistungspaket);

    // then
    List<Leistungspaket> found = leistungspaketRepository.findAll();
    assertThat(found, hasSize(1));
    assertThat(found.get(0).getName(), equalToIgnoringCase(leistungspaketName));
  }

}


