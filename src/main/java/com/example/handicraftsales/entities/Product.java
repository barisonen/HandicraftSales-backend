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
    public String converted;
    public String shortDesc;
    public String description;



    public Product() {}

    public Product(String name, double price, int stock, String converted, String shortDesc, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.converted = converted;
        this.shortDesc = shortDesc;
        this.description = description;
    }
    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", stock: " + stock +", converted: " + converted + ", shorDesc: "
                + shortDesc + ", description: " + description;
    }
}
