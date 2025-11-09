package com.web.lab7.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

/**
 * Request payload for creating a new user.
 *
 * @param email user's email address
 * @param dob user's date of birth
 */
public record CreateUserRequest(
        @NotNull(message = "email is required")
        @Email(message = "email must be valid")
        String email,

        @NotNull(message = "date of birth is required")
        @Past(message = "date of birth must be in the past")
        LocalDate dob
) {
}
