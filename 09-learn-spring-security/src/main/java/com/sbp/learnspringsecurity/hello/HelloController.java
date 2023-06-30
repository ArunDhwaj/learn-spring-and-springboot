package com.sbp.learnspringsecurity.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
