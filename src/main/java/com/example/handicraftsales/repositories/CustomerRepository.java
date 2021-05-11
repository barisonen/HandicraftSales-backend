package com.example.handicraftsales.repositories;

import com.example.handicraftsales.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByName(String name);

}
