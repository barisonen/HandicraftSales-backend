package com.example.handicraftsales.entities;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    public String id;

    public String name;
    public double price;
    public int stock;
    private String shortDesc;
    private String description;
    private String converted;



    public Product() {}

    public Product(String name, double price, int stock, String shortDesc) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.shortDesc = shortDesc;
    }
    @Override
    public String toString() {
        return name + " - " + price + " - " + stock + " - " + shortDesc;
    }
}
