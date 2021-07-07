package com.example.handicraftsales.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")

public class LoginController {

    @PostMapping
    public HttpStatus login(@RequestBody String username, @RequestBody String password) {
        if("admin@example.com".equals(username) && "1234".equals(password)) {
            return HttpStatus.OK;
        }
        else return HttpStatus.UNAUTHORIZED;
    }
}
