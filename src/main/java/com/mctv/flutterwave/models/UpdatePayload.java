package com.mctv.flutterwave.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

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
    // @Expose
    // private String isflutterwave;
    @Expose
    private String currency;
    // @Expose
    // private String transactioncode;


    public UpdatePayload() {
    this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPurchase_type() {
        return purchase_type;
    }

    public void setPurchase_type(String purchase_type) {
        this.purchase_type = purchase_type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }
}
