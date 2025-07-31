package com.shorturl.shortcut.controller;

import com.shorturl.shortcut.exception.RouteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/**")
    public void handleUnknownRequest(HttpServletRequest request){
        throw new RouteNotFoundException(request.getRequestURI());
    }
}
