package com.example.outside;

import org.springframework.stereotype.Component;

@Component
public class Demo {
    public Demo() {
        System.out.println("outside the base package");
    }
}
