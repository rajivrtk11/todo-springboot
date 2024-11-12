package com.example.todoApp.Services;

import com.example.todoApp.DataTransferObject.TaskDto;
import com.example.todoApp.DataTransferObject.UserDto;
import com.example.todoApp.Model.Task;
import com.example.todoApp.Model.User;
import com.example.todoApp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<TaskDto> getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        Task task1 = taskRepository.findUserByTitle("Task 1");
//        Task task1 = taskRepository.findByDescription("Description for Task 1");
        System.out.println("taks is desc"+ task1);


        User user = task.getUser();
        UserDto userDto = new UserDto(user.getId(), user.getUsername());
        TaskDto taskDto = new TaskDto(task.getId(), task.getTitle(), task.getDescription(), userDto);

        return ResponseEntity.ok(taskDto);
    }
}
