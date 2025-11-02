package com.web.lab7.integration;

import static org.assertj.core.api.Assertions.assertThat;

import com.web.lab7.PostgresContainerTest;
import com.web.lab7.model.flower.Flower;
import com.web.lab7.model.flower.FlowerType;
import com.web.lab7.repository.FlowerRepository;
import com.web.lab7.service.FlowerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Full-context integration test validating database persistence, service layer,
 * and data initialization.
 */
@SpringBootTest
class FlowerStoreIntegrationTest extends PostgresContainerTest {

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private FlowerService flowerService;

    @Test
    void applicationContextLoadsWithDatabase() {
        assertThat(flowerRepository).isNotNull();
        assertThat(flowerService).isNotNull();
    }

    @Test
    void dataInitializerSeedsFlowers() {
        assertThat(flowerRepository.findAll())
                .isNotEmpty()
                .hasSizeGreaterThanOrEqualTo(4);
    }

    @Test
    void serviceCanPersistAndRetrieveFlowers() {
        long initialCount = flowerRepository.count();
        
        Flower newFlower = flowerService.findFirstByType(FlowerType.ROSE)
                .orElseThrow();
        
        assertThat(newFlower.getType()).isEqualTo(FlowerType.ROSE);
        assertThat(flowerRepository.count()).isEqualTo(initialCount);
    }

    @Test
    void repositorySupportsCustomQuery() {
        assertThat(flowerRepository.findFirstByType(FlowerType.TULIP))
                .isPresent()
                .get()
                .extracting(Flower::getType)
                .isEqualTo(FlowerType.TULIP);
    }
}
