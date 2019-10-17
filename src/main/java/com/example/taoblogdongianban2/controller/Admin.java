package com.example.taoblogdongianban2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {
    @GetMapping("/hello")
    public String hello() {
        return "hello"; // Trả về hello.html
    }

}
