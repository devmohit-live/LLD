package com.devmohitlive.lld.strategy.payment;


import com.devmohitlive.lld.strategy.payment.handlers.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService{
    //Can't use @Autowired here as there is no bean defined to fill map with PaymentMethod and IPaymentHandler
    Map<PaymentMethod, IPaymentHandler> paymentHandlers;
    public PaymentService(){
        this.paymentHandlers =  new HashMap<>();
        paymentHandlers.put(PaymentMethod.CREDIT_CARD, new CreditCardPaymentHandler());
        paymentHandlers.put(PaymentMethod.DEBIT_CARD, new DebitCardPaymentHandler());
        paymentHandlers.put(PaymentMethod.UPI, new UPIPaymentHandler());
        paymentHandlers.put(PaymentMethod.PAYTM, new PaytmPaymentHandler());
    }

    public PaymentStatus pay(PaymentMethod paymentMethod, String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount){
        return paymentHandlers.get(paymentMethod).pay(cardNumber, cvv, expiryDate, upiAddress, paytmNumber, amount);
    }
}
