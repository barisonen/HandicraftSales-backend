package com.example.handicraftsales;

import com.example.handicraftsales.entities.Customer;
import com.example.handicraftsales.entities.Product;
import com.example.handicraftsales.repositories.CustomerRepository;
import com.example.handicraftsales.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HandicraftSalesApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(HandicraftSalesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.deleteAll();
		productRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer("baris", "onen", "asdasd@gmail.com"));
		customerRepository.save(new Customer("osman", "kedi", "qweqwe@gmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		System.out.println("--------------------------------");

		productRepository.save(new Product("yüzük", 200, 5, "Güzel bir yüzük"));

		System.out.println("Products found with findAll():");
		for(Product product : productRepository.findAll()) {
			System.out.println(product);
		}
	}

}
