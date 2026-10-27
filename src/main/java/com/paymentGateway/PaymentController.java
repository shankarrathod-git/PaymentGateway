package com.paymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    protected String initiatePayment(@RequestParam int userId, @RequestParam double amount){

        return paymentService.initiatePayment(userId, amount);
    }

    @PostMapping("/payment_body")
    protected Payment createPayment(@RequestBody Payment payment){

        return paymentService.createPayment(payment);
        //POST /payments
        //{
        //    "userId": 101,
        //    "transactionId": "TXN001",
        //    "amount": 500,
        //    "status": "PENDING"
        //}
    }

    @PostMapping("/bulk")
    public List<Payment> bulkPayment( @RequestBody List<Payment> payments){
        return paymentService.bulkPayment(payments);
    }


    @GetMapping("/{id}")
    protected Payment getPaymentById(@PathVariable  Long id){
      return paymentService.getPaymentById(id);
      //GET /payments/1
    }

    //Get By TransactionId
    @GetMapping("/transaction/{transactionId}")
    protected Payment getPaymentByTransactionId(String transactionId){
        return paymentService.getPaymentByTransactionId(transactionId);

        //GET /payments/transaction/TXN001
    }

    @PutMapping("/update/{id}")
   protected Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatepayments){

        return paymentService.updatePayment(id, updatepayments);
   }
}
