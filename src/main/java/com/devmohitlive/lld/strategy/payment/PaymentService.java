package com.devmohitlive.lld.strategy.payment;


import com.devmohitlive.lld.strategy.payment.handlers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService{
    @Autowired
    List<IPaymentHandler> paymentHandlers;

    public PaymentStatus pay(PaymentMethod paymentMethod, String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount){
       PaymentStatus status = null;
       for (IPaymentHandler paymentHandler : paymentHandlers) {
           if (paymentHandler.isValidPaymentMethod(paymentMethod)) {
               status = paymentHandler.pay(cardNumber, cvv, expiryDate, upiAddress, paytmNumber, amount);
               break;
           }
       }
        return status;
    }
}
