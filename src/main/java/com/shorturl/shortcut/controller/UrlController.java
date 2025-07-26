package com.shorturl.shortcut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/url")
public class UrlController {

    @GetMapping
    public String getUrl(){
        return "Hello world";
    }

    @PostMapping
    public String postUrl(){
        return "Hello World";
    }
}
