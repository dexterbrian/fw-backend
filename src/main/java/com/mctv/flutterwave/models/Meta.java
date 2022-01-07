package com.mctv.flutterwave.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * The class Meta implements serializable
 *
 * @see Payload
 */
public class Meta implements Serializable {
    @Expose
    String contentRef;
    @Expose
    String transactiontype;

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    /**
     * Gets the content ref
     *
     * @return the content ref
     */
    public String getContentRef() {

        return contentRef;
    }

    /**
     * Sets the content ref
     *
     * @param contentRef the content ref
     */
    public void setContentRef(String contentRef) {

        this.contentRef = contentRef;
    }
}
