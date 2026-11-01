package com.paymentGateway.customer.service;

import com.paymentGateway.customer.entity.CustomerDTO;
import com.paymentGateway.customer.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepo repo;

    public CustomerService(CustomerRepo repo){
        this.repo = repo;
    }

    public CustomerDTO getCustomer(int customerId) {
        return repo.findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));
    }

}
