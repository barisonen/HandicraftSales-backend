package com.example.handicraftsales.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {

    @Id
    public String id;

    public String name;
    public String password;
    public String email;

    public Customer() {}

    public Customer(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
       return "name: " + name + ", email: " + email;
    }

}
