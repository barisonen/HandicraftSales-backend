package com.example.handicraftsales.controllers;

import com.example.handicraftsales.entities.Customer;
import com.example.handicraftsales.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://handicraftsales-frontend.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final MongoTemplate mongoTemplate;

    public CustomerController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {

        return mongoTemplate.findAll(Customer.class, "Customers");
    }

    @DeleteMapping("/deleteAll")
    public HttpStatus deleteAll() {

        mongoTemplate.remove(new Query(), "Customers");
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, "Customers");
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public HttpStatus addCustomer(@RequestBody Customer customer) {

        mongoTemplate.insert(customer);
        return HttpStatus.OK;
    }

}
