package com.example.handicraftsales;

import com.example.handicraftsales.entities.Customer;
import com.example.handicraftsales.entities.Product;
import com.example.handicraftsales.repositories.CustomerRepository;
import com.example.handicraftsales.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;


@SpringBootApplication
public class HandicraftSalesApplication implements CommandLineRunner {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public HandicraftSalesApplication(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(HandicraftSalesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println();
		for(Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("---");

		for(Product product : productRepository.findAll()) {
			System.out.println(product);
		}
		System.out.println();

	}

}
