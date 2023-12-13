package com.grocerystore.store;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public List<Customer> getAllCustomer(){
        List<Customer> customers = new ArrayList<Customer>();
        customers = customerService.getAllCustomer();
        System.out.println(customers);
        return customers;
    }
}
