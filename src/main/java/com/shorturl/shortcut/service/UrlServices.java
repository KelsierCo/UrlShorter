package com.shorturl.shortcut.service;

import com.shorturl.shortcut.model.Url;
import com.shorturl.shortcut.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UrlServices {

    @Autowired
    private UrlRepository urlRepository;

    public String getUrl(){
        return "Hello World";
    }

    public void post(String urlOriginal){
        String shorUrl = generateShortUrl(urlOriginal);
        Url url = new Url(urlOriginal, shorUrl);
        urlRepository.save(url);
    }

    private String generateShortUrl(String originalUrl){
        return "1";
    }
}
