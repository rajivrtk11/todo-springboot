package com.example.todoApp.Repositories;

import com.example.todoApp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    Task findByTitle(String title);

    Task findByDescription(String s);

    @Query(value = "SELECT * FROM tasks u WHERE u.title = :title", nativeQuery = true)
    Task findUserByTitle(@Param("title") String title);
}