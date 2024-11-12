package com.example.todoApp.Repositories;

import com.example.todoApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByUsername(String username);

    @Query(value = "SELECT * FROM users u WHERE u.timestamp BETWEEN :startTime AND :endTime", nativeQuery = true)
    List<User> findUsersBetweenTimestamps(@Param("startTime") LocalDateTime startTime,
                                          @Param("endTime") LocalDateTime endTime);
    // No need to implement methods manually. Spring Data JPA will provide implementations.
}
