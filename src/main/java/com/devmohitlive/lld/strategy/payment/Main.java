package com.devmohitlive.lld.strategy.payment;

public class Main {
    public static void main(String[] args) {
        PaymentService payment = new PaymentService();
        //card
        payment.pay("1234 5678 9012 3456", "123", "12/23", null,null,1000);
        //upi
        payment.pay(null,null, null, "mohit@upi", null,1000);
        // patym
        payment.pay(null,null, null, null,"9999999999",1000);
    }
}
