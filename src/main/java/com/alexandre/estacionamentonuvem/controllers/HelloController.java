package com.alexandre.estacionamentonuvem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/v1")
@ApiIgnore
public class HelloController {

    @GetMapping
    public String hello() {
        return "Bem Vindo ao primeiro projeto!";
    }
}
