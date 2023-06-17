package com.sbp.learnwebapp.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello! What are you learning Today !";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String helloHtml(){

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First Web page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My First HTML Page !");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("/hello-jsp")
//    @ResponseBody
    public String helloJsp() {
        return "SayHello";
    }
}
