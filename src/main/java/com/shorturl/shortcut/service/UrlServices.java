package com.shorturl.shortcut.service;

import com.shorturl.shortcut.model.Url;
import com.shorturl.shortcut.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UrlServices {

    @Autowired
    private UrlRepository urlRepository;

    public ResponseEntity<Void> getUrl(String urlShort){
        String url = urlRepository.findAll().get(0).getUrl();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    public void postUrl(String urlOriginal){
        String shorUrl = generateShortUrl(urlOriginal);
        Url url = new Url(urlOriginal, shorUrl);
        urlRepository.save(url);
    }

    private String generateShortUrl(String originalUrl){
        return "1";
    }
}
