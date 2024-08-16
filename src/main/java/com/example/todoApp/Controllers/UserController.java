package com.example.todoApp.Controllers;

import com.example.todoApp.DataTransferObject.UserDto;
import com.example.todoApp.Model.User;
import com.example.todoApp.Repositories.UserRepository;
import com.example.todoApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUserWithTasks(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/id/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
