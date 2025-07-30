package com.shorturl.shortcut.model;

import jakarta.persistence.*;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @Column(unique = true)
    private String shortUrl;

    public Url() {
    }

    public Url(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
