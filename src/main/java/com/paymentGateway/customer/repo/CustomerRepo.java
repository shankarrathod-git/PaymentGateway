package com.paymentGateway.customer.repo;

import com.paymentGateway.customer.entity.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDTO, Integer> {
}
