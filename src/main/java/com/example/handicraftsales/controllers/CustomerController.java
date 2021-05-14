package com.example.handicraftsales.controllers;

import com.example.handicraftsales.entities.Customer;
import com.example.handicraftsales.repositories.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {

        List<Customer> currentData = customerRepository.findAll();
        if(currentData == null)
            return new ArrayList<>();
        return currentData;
    }

    @PatchMapping
    public HttpStatus createDefaultData() {
        List<Customer> currentData = getAllCustomers();
        if(currentData.isEmpty()) {
            List<Customer> newData = new ArrayList<>();
            newData.add(new Customer("baris onen", "1234", "barisonen.1996@gmail.com"));
            newData.add(new Customer("burhan altintop", "qwerty","burhan_altintop@gmail.com"));
            customerRepository.saveAll(newData);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("/deleteAll")
    public HttpStatus deleteAll() {
        customerRepository.deleteAll();
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteById(@PathVariable String id) {
        Optional<Customer> c = customerRepository.findById(id);
        if(c.isPresent()) {
            customerRepository.deleteById(id);
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.NOT_MODIFIED;
        }
    }



}
