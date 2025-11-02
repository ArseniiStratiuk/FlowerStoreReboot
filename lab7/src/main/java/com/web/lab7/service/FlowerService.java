package com.web.lab7.service;

import com.web.lab7.model.flower.Flower;
import com.web.lab7.model.flower.FlowerType;
import com.web.lab7.repository.FlowerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provides flower catalogue data backed by the database.
 */
@Service
@Transactional
public class FlowerService {

    /**
     * Repository exposing CRUD operations for flowers.
     */
    private final FlowerRepository flowerRepository;

    public FlowerService(final FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    /**
     * Returns every flower stored in the repository.
     *
     * @return list of persisted flowers
     */
    @Transactional(readOnly = true)
    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    /**
     * Persists a flower entity.
     *
     * @param flower entity to store
     * @return saved flower instance
     */
    public Flower save(final Flower flower) {
        return flowerRepository.save(flower);
    }

    /**
     * Retrieves the first flower of the provided type if present.
     *
     * @param type flower species to search for
     * @return optional containing the first matching flower
     */
    @Transactional(readOnly = true)
    public Optional<Flower> findFirstByType(final FlowerType type) {
        return flowerRepository.findFirstByType(type);
    }

    /**
     * Retrieves the first flower of the provided type or fails when none is
     *     stored yet.
     *
     * @param type flower species to search for
     * @return matching flower entity
     */
    @Transactional(readOnly = true)
    public Flower requireByType(final FlowerType type) {
    return findFirstByType(type)
        .orElseThrow(() -> new IllegalArgumentException(
            "Flower type " + type + " is not present in the catalogue"
        ));
    }
}
