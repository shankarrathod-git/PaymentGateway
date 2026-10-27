package com.paymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public String initiatePayment(int userId, double amount){

       String transactionId = UUID.randomUUID().toString();

       Payment payment = new Payment();

       payment.setUserId(userId);
       payment.setTransactionId(transactionId);
       payment.setAmount(amount);
       payment.setStatus("SUCCESSFUL");

       paymentRepo.save(payment);
       return transactionId;
    }

    //CREATE -> controller method expects a single Payment object:
    public Payment createPayment(Payment payment){

        return paymentRepo.save(payment);
    }

    //Create -> If you want to save list of of object or more than one object at a time
    public List<Payment> bulkPayment(List<Payment> payments){
        return paymentRepo.saveAll(payments);
    }
    //READ ALL
    public List<Payment> getAllPayments(){

        return paymentRepo.findAll();
    }

    //READ BY ID
    public Payment getPaymentById(Long id){

        return paymentRepo.findById(id).orElse(null);
    }

    //By TransactionId
    public Payment getPaymentByTransactionId(String transactionId){

        return paymentRepo.findByTransactionId(transactionId).orElse(null);
    }

    //UPDATE
    public Payment updatePayment(Long id, Payment updatePayments){

       Payment payment = paymentRepo.findById(id).orElse(null);

       if(payment != null){
           payment.setUserId(updatePayments.getUserId());
           payment.setAmount(updatePayments.getAmount());
           payment.setStatus(updatePayments.getStatus());
           payment.setTransactionId(updatePayments.getTransactionId());

           return paymentRepo.save(payment);
       }
       return null;

    }
}
