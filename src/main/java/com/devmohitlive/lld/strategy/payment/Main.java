package com.devmohitlive.lld.strategy.payment;


public class Main {
    public static void main(String[] args) {
        PaymentStatus status;
        PaymentService payment = new PaymentService();
        try {
            //card
            status = payment.pay(PaymentMethod.CREDIT_CARD,"1234 5678 9012 3456", "123", "12/23", null,null,1000);
            System.out.println(status);
            //upi
            status = payment.pay(PaymentMethod.UPI,null,null, null, "mohit@upi", null,1000);
            System.out.println(status);
            // patym
            status = payment.pay(PaymentMethod.PAYTM,null,null, null, null,"9999999999",1000);
            System.out.println(status);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
