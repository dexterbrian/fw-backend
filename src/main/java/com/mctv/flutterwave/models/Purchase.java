package com.mctv.flutterwave.models;

/**
 * @author Brian Weloba
 * @author Hamisi Andale
 * 
 *         1. This class is the model for the puchase payload.
 * 
 * 
 */
public class Purchase {
    private String id;
    private String amount;
    private String createdon;
    private String invoice_id;
    private String purchase_type;
    private String ref;
    private String title;

    /**
     * Gets the identifier
     * 
     * @return the identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the identifier
     * 
     * @param id
     *           the identifier to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the amount
     * 
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount
     * 
     * @param amount
     *               the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the createdon
     * 
     * @return the createdon
     */
    public String getCreatedon() {
        return createdon;
    }

    /**
     * Sets the createdon
     * 
     * @param createdon
     *                  the createdon to set
     */
    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    /**
     * Gets the invoice_id
     * 
     * @return the invoice_id
     */
    public String getInvoice_id() {
        return invoice_id;
    }

    /**
     * Sets the invoice_id
     * 
     * @param invoice_id
     *                   the invoice_id to set
     */
    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
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
     * @param purchase_type
     *                      the purchase_type to set
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
     * @param ref
     *            the ref to set
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Gets the title
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title
     * 
     * @param title
     *              the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
