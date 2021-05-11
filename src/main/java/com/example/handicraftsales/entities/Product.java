package com.example.handicraftsales.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {
    @Id
    public String id;

    public String name;
    public double price;
    public int stock;



    public Product() {}

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", stock: " + stock;
    }
}
