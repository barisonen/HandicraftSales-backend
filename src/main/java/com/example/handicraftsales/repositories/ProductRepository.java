package com.example.handicraftsales.repositories;

import com.example.handicraftsales.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
