package com.example.todoApp.Services;

import com.example.todoApp.DataTransferObject.UserDto;
import com.example.todoApp.Model.User;
import com.example.todoApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    private Specification<User> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), status);
    }

    public List<User> getUser(Long id) {
        Specification<User> usersWithName = hasStatus("john_1");

        Specification<User> activeJohns = Specification.where(usersWithName);
        List<User> users = userRepository.findUsersBetweenTimestamps(
                LocalDateTime.of(2024, 8, 1, 0, 0),
                LocalDateTime.of(2024, 8, 26, 0, 0)
        );

        return userRepository.findAll(activeJohns);
    }
}
