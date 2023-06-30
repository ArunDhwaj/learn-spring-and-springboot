package com.sbp.learnspringsecurity.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> LIST = Arrays.asList(new Todo("sbp", "Learn Spring Security"),
            new Todo("sbp", "Learn AWS"));

    @GetMapping("todos")
    public List<Todo> retrieveTodos(){
        return LIST;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodosForUser(@PathVariable String username){
        return LIST;
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForUser(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, username);
    }

}
record Todo(String username, String description){}
