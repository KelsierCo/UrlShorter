package com.shorturl.shortcut.exception;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException(String path){
        super(path);
    }
}
