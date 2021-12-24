package com.mctv.flutterwave.models;

public class BackendResponse {
    private String message;
    private Purchase Purchase;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Purchase getPurchase() {
        return Purchase;
    }

    public void setPurchase(Purchase purchase) {
        Purchase = purchase;
    }
}
