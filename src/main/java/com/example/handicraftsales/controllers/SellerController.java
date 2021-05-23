package com.example.handicraftsales.controllers;

import com.example.handicraftsales.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private final MongoTemplate mongoTemplate;

    public SellerController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<Seller> getAllSellers() {

        return mongoTemplate.findAll(Seller.class, "Sellers");
    }

    @DeleteMapping("/deleteAll")
    public HttpStatus deleteAll() {

        mongoTemplate.remove(new Query(), "Sellers");
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, "Sellers");
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public HttpStatus addSeller(@RequestBody Seller seller) {

        mongoTemplate.insert(seller);
        return HttpStatus.OK;
    }

}
