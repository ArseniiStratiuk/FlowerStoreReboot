package com.web.lab7.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

/**
 * Domain object representing a user of the application.
 */
@Entity
@Table(name = "app_users")
public class AppUser {

    /**
     * Technical identifier managed by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User's email address (must be unique).
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * User's date of birth.
     */
    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    /**
     * Creates a user with default values.
     */
    public AppUser() {
    }

    /**
     * Creates a user with specified email and date of birth.
     *
     * @param userEmail user's email address
     * @param dateOfBirth user's date of birth
     */
    public AppUser(final String userEmail, final LocalDate dateOfBirth) {
        this.email = userEmail;
        this.dob = dateOfBirth;
    }

    /**
     * @return user identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * @return user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates the email address.
     *
     * @param newEmail new email address
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
    }

    /**
     * @return user's date of birth
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Updates the date of birth.
     *
     * @param dateOfBirth new date of birth
     */
    public void setDob(final LocalDate dateOfBirth) {
        this.dob = dateOfBirth;
    }

    /**
     * Calculates user's age from date of birth.
     * This field is not persisted in the database.
     *
     * @return user's age in years
     */
    @Transient
    public int getAge() {
        if (dob == null) {
            return 0;
        }
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
