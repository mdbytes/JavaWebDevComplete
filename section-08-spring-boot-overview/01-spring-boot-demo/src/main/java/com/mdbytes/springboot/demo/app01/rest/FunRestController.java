package com.mdbytes.springboot.demo.app01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose / end point to return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
