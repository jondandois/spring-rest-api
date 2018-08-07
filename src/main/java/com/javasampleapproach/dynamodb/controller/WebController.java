package com.javasampleapproach.dynamodb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.dynamodb.model.Customer;
import com.javasampleapproach.dynamodb.repo.CustomerRepository;

@RestController
public class WebController {

	@Autowired
	CustomerRepository repository;

	@RequestMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}

	@RequestMapping("/save")
	public String save() {
		// save a single Customer
		repository.save(new Customer("1", "Jack", "Smith"));

		// save a list of Customers
		repository.save(Arrays.asList(new Customer("2", "Adam", "Johnson"), new Customer("3", "Kim", "Smith"),
				new Customer("4", "David", "Williams"), new Customer("5", "Peter", "Davis")));

		return "Done";
	}

	@RequestMapping("/findall")
	public Iterable<Customer> findAll() {
		return repository.findAll();
	}

	@RequestMapping("/findbyid")
	public Customer findById(@RequestParam("id") String id) {
		return repository.findOne(id);
	}

	@RequestMapping("/findbyfirstname")
	public Iterable<Customer> fetchDataByFirstName(@RequestParam("firstname") String firstname) {
		return repository.findByFirstName(firstname);
	}
}
