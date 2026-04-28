package com.fsadproject.ps30.controller;

import com.fsadproject.ps30.entity.User;
import com.fsadproject.ps30.repository.UserRepository;
import com.fsadproject.ps30.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // allow local + deployed frontend
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    private final UserRepository userRepository;

    // constructor injection
    public UserController(UserService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    // ✅ create user (signup)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }

    // ✅ get all users
    @GetMapping
    public List<User> getUsers() {
        return service.getAll();
    }

    // 🔥 LOGIN API (real authentication)
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        User existing = userRepository.findByEmail(user.getEmail());

        if (existing != null && existing.getPassword() != null
                && existing.getPassword().equals(user.getPassword())) {
            return existing;
        }

        throw new RuntimeException("Invalid email or password");
    }
}