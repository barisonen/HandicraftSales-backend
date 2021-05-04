package com.example.handicraftsales.repositories;

import com.example.handicraftsales.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);

}
