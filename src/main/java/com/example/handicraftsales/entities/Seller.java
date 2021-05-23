package com.example.handicraftsales.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sellers")
public class Seller {
    @Id
    public String id;

    public String name;
    public String email;
    public String picture;
    public String rate;
    public String comments;

    public Seller() {}

    public Seller(String name, String email, String picture, String rate, String comments) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.rate = rate;
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "name: " + name + ", email: " + email + ", picture: " + picture +", rate: " + rate + ", comments: "
                + comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
