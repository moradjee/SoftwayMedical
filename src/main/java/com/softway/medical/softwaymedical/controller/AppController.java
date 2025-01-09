package com.softway.medical.softwaymedical.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController  {

    @GetMapping("/test")
    String all() {
        return "Bonjour";
    }
}
