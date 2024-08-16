package com.example.todoApp.Controllers;

import com.example.todoApp.Model.Task;
import com.example.todoApp.Model.User;
import com.example.todoApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> createUserWithTasks(@RequestBody User user) {
        System.out.println("user is"+ user);
        try {
            // Save the user along with the associated tasks
            User savedUser = userRepository.save(user);

            // Return the saved user
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user: " + e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userRepository.getById(id);
        return user;
    }
}
