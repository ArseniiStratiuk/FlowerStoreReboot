package com.web.lab7;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.wait.strategy.Wait;
import java.time.Duration;

/**
 * Shared PostgreSQL Testcontainers setup for integration tests.
 */
@Testcontainers
public abstract class PostgresContainerTest {

    @Container
    @SuppressWarnings("resource")
    private static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:16-alpine")
        .withDatabaseName("flowerstore")
        .withUsername("flower")
        .withPassword("flower")
        .withReuse(true)
        .waitingFor(Wait.forListeningPort())
        .withStartupTimeout(Duration.ofSeconds(60));

    static {
        POSTGRES.start();
    }

    @DynamicPropertySource
    static void configureDatasource(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
    }
}
