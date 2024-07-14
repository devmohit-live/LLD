package com.devmohitlive.lld.strategy.payment.dto;

public class UPIPaymentRequest implements IPaymentRequest{
    private String upiId;

    public String getUpiId() {
        return upiId;
    }

    public UPIPaymentRequest(String upiId) {
        this.upiId = upiId;
    }
}
