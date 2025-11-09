package com.web.lab7.controller;

import com.web.lab7.controller.dto.CreateUserRequest;
import com.web.lab7.model.user.AppUser;
import com.web.lab7.service.AppUserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing application users.
 */
@RestController
@RequestMapping("/api/v1/users")
public class AppUserController {

    /**
     * Service handling user business logic.
     */
    private final AppUserService appUserService;

    /**
     * Constructor for AppUserController.
     *
     * @param service the user service
     */
    public AppUserController(final AppUserService service) {
        this.appUserService = service;
    }

    /**
     * Returns all registered users.
     *
     * @return list of all users with their calculated ages
     */
    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.findAll();
    }

    /**
     * Registers a new user.
     *
     * @param request user details to create
     * @return the newly created user
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser createUser(
            @Valid @RequestBody final CreateUserRequest request) {
        final AppUser user = new AppUser(request.email(), request.dob());
        return appUserService.addUser(user);
    }
}
