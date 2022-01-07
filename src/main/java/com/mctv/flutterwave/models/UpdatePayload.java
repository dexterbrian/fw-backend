package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * <p>
 * 1. This class is the model for the update payload.
 * 2. It is responsible for holding the update payload details.
 */
@Entity
public class UpdatePayload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Expose
    private String user_id;
    @Expose
    private String purchase_type;
    @Expose
    private String ref;
    @Expose
    private String tx;
    @Expose
    private String currency;

    /**
     * Updates the payload
     *
     */
    public UpdatePayload() {
        this.id = UUID.randomUUID();
    }

    /**
     * Gets the identifier
     *
     * @return the id of the update payload
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier
     *
     * @param id the id of the update payload
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the user_id
     *
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Sets the user_id
     *
     * @param user_id the user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets the purchase_type
     *
     * @return the purchase_type
     */
    public String getPurchase_type() {
        return purchase_type;
    }

    /**
     * Sets the purchase_type
     *
     * @param purchase_type the purchase_type
     */
    public void setPurchase_type(String purchase_type) {
        this.purchase_type = purchase_type;
    }

    /**
     * Gets the ref
     *
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the ref
     *
     * @param ref the ref
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Gets the tx
     *
     * @return the tx
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the tx
     *
     * @return the tx
     */
    public String getTx() {
        return tx;
    }

    /**
     * Sets the tx
     *
     * @param tx the tx
     */
    public void setTx(String tx) {
        this.tx = tx;
    }
}
