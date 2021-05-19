package com.example.handicraftsales.controllers;

import com.example.handicraftsales.entities.Customer;
import com.example.handicraftsales.entities.Product;
import com.example.handicraftsales.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
/*
    @PatchMapping
    public HttpStatus createDefaultData() {
        List<Product> currentData = getAllProducts();
        if(currentData.isEmpty()) {
            List<Product> newData = new ArrayList<>();
            newData.add(new Product("Kolye", 100, 10));
            newData.add(new Product("Yüzük", 150,5));
            productRepository.saveAll(newData);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_MODIFIED;
    }
*/
    @DeleteMapping("/deleteAll")
    public HttpStatus deleteAll() {
        productRepository.deleteAll();
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable String id) {
        Optional<Product> c = productRepository.findById(id);
        if(c.isPresent()) {
            productRepository.deleteById(id);
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.NOT_MODIFIED;
        }
    }

    @PostMapping("/add")
    public HttpStatus addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return HttpStatus.OK;
    }
}
