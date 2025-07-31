package com.shorturl.shortcut.service;

import com.shorturl.shortcut.exception.RouteNotFoundException;
import com.shorturl.shortcut.model.Url;
import com.shorturl.shortcut.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UrlServices {

    @Autowired
    private UrlRepository urlRepository;

    public ResponseEntity<Void> getUrl(String urlShort){
        String url = urlRepository.findByShortUrl(urlShort)
                .map(Url::getUrl)
                .orElseThrow(() -> new RouteNotFoundException("URL no encontrada"));
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    public String postUrl(String urlOriginal){
        String shorUrl = generateShortUrl(urlOriginal);
        Url url = new Url(urlOriginal, shorUrl);
        urlRepository.save(url);
        return shorUrl;
    }

    private String generateShortUrl(String originalUrl){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalUrl.getBytes());
            byte[] digest = md.digest();

            StringBuilder sb = new StringBuilder();
            for(byte b : digest){
                sb.append(String.format("%02x", b));
            }

            return sb.substring(0, 8);
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error generando el hash");
        }
    }
}
