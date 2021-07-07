package com.example.handicraftsales.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://handicraftsales-frontend.herokuapp.com/", maxAge = 3600)
@RestController
@RequestMapping("/customers")

public class LoginController {

    @PostMapping("/login")
    public HttpStatus login(@RequestBody String username, @RequestBody String password) {
        if("admin@example.com".equals(username) && "1234".equals(password)) {
            return HttpStatus.OK;
        }
        else return HttpStatus.UNAUTHORIZED;
    }
}
