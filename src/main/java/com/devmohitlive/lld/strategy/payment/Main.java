package com.devmohitlive.lld.strategy.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private PaymentService payment;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PaymentStatus status;
        //card
        status = payment.pay(PaymentMethod.CREDIT_CARD,"1234 5678 9012 3456", "123", "12/23", null,null,1000);
        System.out.println(status);
        //upi
        status = payment.pay(PaymentMethod.UPI,null,null, null, "mohit@upi", null,1000);
        System.out.println(status);
        // paytm
        status = payment.pay(PaymentMethod.PAYTM,null,null, null, null,"9999999999",1000);
        System.out.println(status);
    }
}