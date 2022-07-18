package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class  HelloController {

    @GetMapping("/hello")
    @ResponseBody

    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/goodbye")
    @ResponseBody

    public String goodbye(){
        return "Goodbye from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody

    public String sayHello(@PathVariable String name){
        return "Hello" + name;
    }

    @GetMapping("/books/{id}")
    @ResponseBody

    public String getBook(@PathVariable long id){
        return "Here's your book id: " + id;
    }
}