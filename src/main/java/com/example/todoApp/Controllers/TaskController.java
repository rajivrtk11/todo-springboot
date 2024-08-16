package com.example.todoApp.Controllers;

import com.example.todoApp.DataTransferObject.TaskDto;
import com.example.todoApp.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getTask")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/id/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return taskService.getTask(id);
    }
}
