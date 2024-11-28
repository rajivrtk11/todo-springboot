package com.example.todoApp.Controllers;

import com.example.todoApp.DataTransferObject.UserDto;
import com.example.todoApp.Model.User;
import com.example.todoApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping()
    public List<User> getUser() {
        return userService.getAllUsers();
    }
}
