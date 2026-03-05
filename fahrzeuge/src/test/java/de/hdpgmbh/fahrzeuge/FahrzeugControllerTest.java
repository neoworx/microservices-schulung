
package de.hdpgmbh.fahrzeuge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;

import de.hdpgmbh.fahrzeuge.controller.v1.FahrzeugController;
import de.hdpgmbh.fahrzeuge.model.Fahrzeug;
import de.hdpgmbh.fahrzeuge.repository.FahrzeugRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2")
class FahrzeugControllerTest {

  @Autowired
  private FahrzeugController fahrzeugController;

  @Autowired
  private FahrzeugRepository fahrzeugRepository;

  @Test
  public void contextLoads() {}

  @Test
  void createFahrzeug_shouldCreateCorrectFahrzeug() {

    // given
    String fahrzeugName = "Test Fahrzeug";
    Fahrzeug testFahrzeug = new Fahrzeug(fahrzeugName);

    // when
    fahrzeugController.createFahrzeug(testFahrzeug);

    // then
    List<Fahrzeug> found = fahrzeugRepository.findAll();
    assertThat(found, hasSize(1));
    assertThat(found.get(0).getName(), equalToIgnoringCase(fahrzeugName));
  }

}

