package com.example.todoApp.Repositories;

import com.example.todoApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to implement methods manually. Spring Data JPA will provide implementations.
}
