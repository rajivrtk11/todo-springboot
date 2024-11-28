package com.example.todoApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PublicController {
    public PublicController() {
        System.out.println("inside the base package");
    }
    @GetMapping
    public String getPublic() {
        return "Public route";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Public route";
    }
}
