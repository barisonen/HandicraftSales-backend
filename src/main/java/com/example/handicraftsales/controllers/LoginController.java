package com.example.handicraftsales.controllers;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/login")

public class LoginController {

    private static JSONObject jObject = null;
    String email = "";
    String password = "";

    @PostMapping
    public HttpStatus login(@RequestBody String object) throws JSONException {
        jObject = new JSONObject(object);
        email = jObject.getString("email");
        password = jObject.getString("password");
        if("admin@example.com".equals(email) && "1234".equals(password)) {
            return HttpStatus.OK;
        }
        else return HttpStatus.UNAUTHORIZED;
    }
}
