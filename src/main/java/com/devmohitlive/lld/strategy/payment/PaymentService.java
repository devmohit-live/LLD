package com.devmohitlive.lld.strategy.payment;


import com.devmohitlive.lld.strategy.payment.vendors.CreditCard;
import com.devmohitlive.lld.strategy.payment.vendors.DebitCard;
import com.devmohitlive.lld.strategy.payment.vendors.Paytm;
import com.devmohitlive.lld.strategy.payment.vendors.UPI;

public class PaymentService {
    public PaymentStatus pay(String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount){
        if(cardNumber != null && cvv != null && expiryDate != null){
            // Credit card payment
            return new CreditCard().pay(cardNumber, cvv, expiryDate, amount);
        } else if(cardNumber != null && cvv != null){
            // Debit card payment
            return new DebitCard().pay(cardNumber, cvv, expiryDate, amount);
        } else if(upiAddress != null){
            // UPI payment
            return new UPI().pay(upiAddress, amount);
        } else if(paytmNumber != null){
            // Paytm payment
            return new Paytm().pay(paytmNumber, amount);
        } else {
            return PaymentStatus.FAILED;
        }
    }
}
