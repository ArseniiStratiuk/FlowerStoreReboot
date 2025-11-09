package com.web.lab7.repository;

import com.web.lab7.model.user.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for AppUser persistence operations.
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    /**
     * Finds a user by their email address.
     * Ensures email uniqueness in the system.
     *
     * @param email the email address to search for
     * @return optional containing the user if found, empty otherwise
     */
    @Query("SELECT u FROM AppUser u WHERE u.email = ?1")
    Optional<AppUser> findUserByEmail(String email);
}
