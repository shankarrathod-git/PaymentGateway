package com.paymentGateway.customer.controller;

import com.paymentGateway.customer.entity.CustomerDTO;
import com.paymentGateway.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @PostMapping("/fetch/{id}")
    public CustomerDTO  fetchById(@PathVariable int id){

        return service.getCustomer(id);
    }

}
