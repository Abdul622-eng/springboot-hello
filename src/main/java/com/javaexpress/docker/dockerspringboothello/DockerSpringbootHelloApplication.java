package com.javaexpress.docker.dockerspringboothello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello DevOps! Application is running successfully 🚀";
    }
}
``
