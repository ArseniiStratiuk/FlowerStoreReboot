package com.web.lab7.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.web.lab7.PostgresContainerTest;
import com.web.lab7.model.flower.Flower;
import com.web.lab7.model.flower.FlowerColor;
import com.web.lab7.model.flower.FlowerType;
import com.web.lab7.repository.FlowerRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(FlowerService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FlowerServiceTest extends PostgresContainerTest {

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private FlowerRepository flowerRepository;

    @BeforeEach
    void setUp() {
        flowerRepository.deleteAll();
        flowerRepository.saveAll(List.of(
                new Flower(FlowerType.ROSE, FlowerColor.RED, 20, 40),
                new Flower(FlowerType.TULIP, FlowerColor.YELLOW, 18, 22)
        ));
    }

    @Test
    void findAllReturnsPersistedFlowers() {
        List<Flower> all = flowerService.findAll();
        assertThat(all).hasSize(2);
    }

    @Test
    void savePersistsNewFlower() {
        Flower saved = flowerService.save(
                new Flower(FlowerType.ROMASHKA, FlowerColor.WHITE, 9, 12)
        );
        assertThat(saved.getId()).isNotNull();
        assertThat(flowerRepository.findAll()).hasSize(3);
    }
}
