package com.sbp.restfulwebservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path= "/hello")
    public String helloWorld()
    {
        return "Hello World !";
    }

    @GetMapping(path= "/hello-bean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path= "/hello/{name}")
    public HelloWorldBean helloPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean("Hello World Bean "+name);
    }
}
