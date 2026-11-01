package com.paymentGateway.customer.entity;

import com.paymentGateway.Payment;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String custName;
    private String custEmailId;

    @OneToMany( mappedBy = "customer")
    private List<Payment> payments;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmailId() {
        return custEmailId;
    }

    public void setCustEmailId(String custEmailId) {
        this.custEmailId = custEmailId;
    }

}
