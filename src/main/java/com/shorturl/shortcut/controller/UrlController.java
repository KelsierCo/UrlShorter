package com.shorturl.shortcut.controller;

import com.shorturl.shortcut.service.UrlServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    UrlServices urlServices;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getUrl(@PathVariable String shortUrl){
        return urlServices.getUrl(shortUrl);
    }

    @PostMapping
    public String postUrl(@RequestBody Map<String, String> json){
        urlServices.postUrl(json.get("url"));
        return "Hello World";
    }
}
