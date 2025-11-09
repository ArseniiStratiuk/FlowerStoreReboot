package com.web.lab7.service;

import com.web.lab7.model.user.AppUser;
import com.web.lab7.repository.AppUserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service providing business logic for user management.
 */
@Service
@Transactional
public class AppUserService {

    /**
     * Repository for user persistence operations.
     */
    private final AppUserRepository appUserRepository;

    /**
     * Constructor for AppUserService.
     *
     * @param repository the user repository
     */
    public AppUserService(final AppUserRepository repository) {
        this.appUserRepository = repository;
    }

    /**
     * Returns all registered users.
     *
     * @return list of all users
     */
    @Transactional(readOnly = true)
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    /**
     * Registers a new user if email is not already taken.
     *
     * @param user the user to register
     * @return the saved user instance
     * @throws IllegalArgumentException if email is already in use
     */
    public AppUser addUser(final AppUser user) {
        if (appUserRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException(
                    "User with email " + user.getEmail() + " already exists"
            );
        }
        return appUserRepository.save(user);
    }
}
