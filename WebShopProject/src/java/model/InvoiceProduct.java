/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Veljko
 */
@Entity
@Table(name = "invoice_product")
public class InvoiceProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceProductId;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne
    private Invoice invoiceId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product productId;

    public InvoiceProduct(Integer invoiceProductId, Invoice invoiceId, Product productId) {
        this.invoiceProductId = invoiceProductId;
        this.invoiceId = invoiceId;
        this.productId = productId;
    }

    public InvoiceProduct(Invoice invoiceId, Product productId) {
        this.invoiceId = invoiceId;
        this.productId = productId;
    }

    public InvoiceProduct(Product productId) {
        this.productId = productId;
    }

    public InvoiceProduct(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceProduct() {
    }
    
    public Integer getInvoiceProductId() {
        return invoiceProductId;
    }

    public void setInvoiceProductId(Integer invoiceProductId) {
        this.invoiceProductId = invoiceProductId;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "InvoiceProduct{" + "invoiceProductId=" + invoiceProductId + ", invoiceId=" + invoiceId + ", productId=" + productId + '}';
    }
    
}
