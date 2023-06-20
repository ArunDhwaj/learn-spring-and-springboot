package com.sbp.restfulwebservices.hello;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {
    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping(path= "/hello-i18n")
    public String helloWorldI18n()
    {
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println("locale: " + locale);
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}
