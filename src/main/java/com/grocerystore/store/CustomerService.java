package com.grocerystore.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        // Logic to add a new customer
        System.out.println(customer);
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}