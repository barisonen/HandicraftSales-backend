package com.example.handicraftsales.controllers;

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
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private final MongoTemplate mongoTemplate;

    public ProductController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return mongoTemplate.findAll(Product.class, "Products");
    }

    @DeleteMapping("/deleteAll")
    public HttpStatus deleteAll() {

        mongoTemplate.remove(new Query(), "Products");
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, "Products");
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public HttpStatus addProduct(@RequestBody Product product) {

        mongoTemplate.insert(product);
        return HttpStatus.OK;
    }


    @PatchMapping("/setAmount/{id}/{newStock}")
    public HttpStatus setAmount(@PathVariable String id, @PathVariable String newStock) {

        Product theProduct = mongoTemplate.findById(id, Product.class);
        int stock = theProduct.getStock();
        if(stock < Integer.parseInt(newStock))
            return HttpStatus.NOT_ACCEPTABLE;
        else {
            Update update = new Update();
            update.set("stock", newStock);
            mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, Product.class);
            return HttpStatus.OK;
        }
    }
}
