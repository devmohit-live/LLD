package com.devmohitlive.lld.strategy.payment;


import com.devmohitlive.lld.strategy.payment.handlers.*;

public class PaymentService{
    IPaymentHandler paymentHandler;
    public PaymentStatus pay(PaymentMethod paymentMethod, String cardNumber, String cvv, String expiryDate, String upiAddress, String paytmNumber, double amount) throws IllegalArgumentException{
       if (paymentMethod == PaymentMethod.CREDIT_CARD){
           paymentHandler = new CreditCardPaymentHandler();
         }else if (paymentMethod == PaymentMethod.PAYTM){
           paymentHandler = new PaytmPaymentHandler();
        }else if (paymentMethod == PaymentMethod.UPI) {
           paymentHandler = new UPIPaymentHandler();
       }else if (paymentMethod == PaymentMethod.DEBIT_CARD){
           paymentHandler = new DebitCardPaymentHandler();
       }else {
           throw new IllegalArgumentException("Invalid Payment Method");
       }

        return paymentHandler.pay(cardNumber, cvv, expiryDate, upiAddress, paytmNumber, amount);
    }
}
