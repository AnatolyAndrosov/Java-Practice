package com.example.springexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @ResponseBody
    @RequestMapping(path = "/hello")
    public String helloSpring() {
        return "Hello, Spring!";
    }
}
