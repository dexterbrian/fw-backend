package com.mctv.flutterwave.models;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * 1. This class is the model for the response from the backend when you
 * update a payment.
 */
public class BackendResponse {
    private String message;
    private Purchase Purchase;

    /**
     * Gets the message
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the Purchase
     *
     * @return the Purchase
     */
    public Purchase getPurchase() {
        return Purchase;
    }

    /**
     * Sets the Purchase
     *
     * @param purchase the Purchase to set
     */
    public void setPurchase(Purchase purchase) {
        Purchase = purchase;
    }
}
