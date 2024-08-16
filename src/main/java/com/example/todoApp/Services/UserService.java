package com.example.todoApp.Services;

import com.example.todoApp.DataTransferObject.UserDto;
import com.example.todoApp.Model.User;
import com.example.todoApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDto> createUser(User user) {
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(new UserDto(savedUser.getId(), savedUser.getUsername()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user: " + e.getMessage());
        }
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
