package com.example.buoi_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllers {
    @RequestMapping("helloWord")
    public String helloWord(){
        return "helloWord";
    }
}
